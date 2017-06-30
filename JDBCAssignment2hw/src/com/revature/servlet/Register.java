package com.revature.servlet;

import com.revature.DAO.UserController;
import com.revature.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        User user = new UserController().createUser(req.getParameter("firstName"),
                req.getParameter("lastName"),
                req.getParameter("username"),
                req.getParameter("password"));

        if (user != null)
        {
            HttpSession session = req.getSession();
            session.setAttribute("user_id", user.getId());

            req.getRequestDispatcher("profile.html").include(req, resp);
        }
    }
}