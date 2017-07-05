package com.revature.servlet;

import com.revature.DAO.UserController;
import com.revature.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by John on 6/30/2017.
 */
public class Register extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("Register post");
        PrintWriter pw = resp.getWriter();

        if (!User.isUsernameAvailable(req.getParameter("username")) )
        {
            System.out.println("Error, username is taken");
            pw.println("That username is taken");
            req.getRequestDispatcher("signup.html").include(req, resp);
        }
        else
        {
            User user = new UserController().createUser(req.getParameter("firstName"),
                    req.getParameter("lastName"),
                    req.getParameter("username"),
                    req.getParameter("password"));

            if (user != null)
            {
                HttpSession session = req.getSession();
                session.setAttribute("username", user.getUsername());

                resp.sendRedirect("/profile");
            }

            System.out.println("user is null");
        }
    }
}