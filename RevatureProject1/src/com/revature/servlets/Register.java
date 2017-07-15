package com.revature.servlets;

import com.revature.dao.oracle.UserOracleDao;
import com.revature.models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * Created by John on 7/14/2017.
 */
public class Register extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Enter register post");

        HttpSession session = request.getSession(false);

        if (session != null)
        {
            if ((int) session.getAttribute("user_role") == 1)
            {
                String firstName = request.getParameter("firstName");
                String lastName = request.getParameter("lastName");
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                String email = request.getParameter("email");
                int role = Integer.parseInt(request.getParameter("role"));

                try
                {
                    UserOracleDao controller = new UserOracleDao();

                    User user = controller.createUser(username, password, email, firstName, lastName, role);

                    if (user == null)
                    {
                        session.setAttribute("create_error", "There was an issue creating their account");
                        response.sendRedirect("/register");
                    }
                } catch (SQLException e)
                {
                    e.printStackTrace();
                }

//                response.sendRedirect("/profile");
            }
        }

        response.sendRedirect("/profile");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("In register get");
        HttpSession session = request.getSession(false);

        if (session != null)
            request.getRequestDispatcher("register.html").include(request, response);
        else
            response.sendRedirect("login");
    }
}
