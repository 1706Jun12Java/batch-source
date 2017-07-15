package com.revature.servlets;

import com.revature.dao.oracle.ReimbursementOracleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig
public class Request extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Enter request post");

        HttpSession session = request.getSession(false);

        if (session != null)
        {
            try
            {
                ReimbursementOracleDao controller = new ReimbursementOracleDao();

                boolean result = controller.createReimbursement(Integer.parseInt(request.getParameter("amount")), request.getParameter("description"),
                        null, (Integer) session.getAttribute("user_id"), Integer.parseInt(request.getParameter("type")));

                if (result)
                    response.sendRedirect("/profile");
                else
                {
                    System.out.println("R was null");
                    response.sendRedirect("/request");
                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        } else
            response.sendRedirect("/request");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("Enter request get");
        HttpSession session = request.getSession(false);

        if (session != null)
            request.getRequestDispatcher("request.html").include(request, response);
        else
            response.sendRedirect("/profile");
    }
}
