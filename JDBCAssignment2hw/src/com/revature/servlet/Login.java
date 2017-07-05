package com.revature.servlet;

import com.revature.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by John on 6/29/2017.
 */
public class Login extends HttpServlet
{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        super.doGet(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
//        System.out.println(req.getParameter("username") );
//        System.out.println(req.getParameter("password") );
        System.out.println("Enter Login post");

        if (!User.authUser(req.getParameter("username"), req.getParameter("password")) )
        {
            System.out.println("Error in combination of username or password");
            PrintWriter pw = res.getWriter();
            pw.println("<p style=\"text-align: center\" class=\"bg-danger\">Error, wrong username or password</p>");
            req.getRequestDispatcher("index.html").include(req, res);
        }
        else
        {
            HttpSession session = req.getSession();
            session.setAttribute("username", req.getParameter("username"));
            res.sendRedirect("/profile");
        }
    }
}
