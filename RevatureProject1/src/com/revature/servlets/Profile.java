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
public class Profile extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        HttpSession session = request.getSession(false);

        if (session != null)
        {
            try
            {
                User user = new UserOracleDao().getUserById((Integer) request.getSession(false).getAttribute("user_id"));

                if (user != null)
                {
                    if (user.getUserRole() == 1)
                        request.getRequestDispatcher("reimbursementHome.html").include(request, response);
                    else
                        request.getRequestDispatcher("employeePortal.html").include(request,response);
                }

            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        else
            response.sendRedirect("/login");
    }
}
