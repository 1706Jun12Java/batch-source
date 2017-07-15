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
 * Created by John on 7/13/2017.
 */
public class Login extends HttpServlet
{

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("In login post");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserOracleDao controller;
        User user;

        try
        {
            controller = new UserOracleDao();
            user = controller.auth(username, password);

            if (user != null)
            {
                HttpSession session = request.getSession();
                session.setAttribute("user_id", user.getId() );
                session.setAttribute("user_role", user.getUserRole() );
                response.sendRedirect("/profile");
            }
            else
            {
                response.sendRedirect("/login");
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("In login get");
        request.getRequestDispatcher("login.html").include(request, response);
    }
}
