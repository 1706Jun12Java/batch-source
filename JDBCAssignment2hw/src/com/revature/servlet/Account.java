package com.revature.servlet;

import com.revature.DAO.AccountController;
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
 * Created by John on 7/4/2017.
 */
public class Account extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        System.out.println("Account post method");
        HttpSession session = req.getSession();
        User user = new UserController().getUserByUsername((String) session.getAttribute("username"));
        PrintWriter pw = resp.getWriter();

        System.out.println("withdraw amount: " + req.getParameter("withdrawAmount") + " deposit amount: " + req.getParameter("depositAmount"));

        if (!req.getParameter("withdrawAmount").equals("") && !req.getParameter("depositAmount").equals(""))
        {
            pw = resp.getWriter();
            pw.println("<p style=\"text-align: center\" class=\"bg-danger\">Error, you should fill out only one field!</p>");
            req.getRequestDispatcher("profile.html").include(req, resp);
        }
        else
        {
            if (!req.getParameter("withdrawAmount").equals("") )
            {
                System.out.println("withdrawing");
                int acc = new AccountController().withdraw(Integer.parseInt(req.getParameter("withdrawAmount")), user.getId(), (Integer) req.getSession(false).getAttribute("accountType"));

                if (acc == -1)
                {
                    System.out.println("Error in withdrawing");
                    req.getRequestDispatcher("profile.html").include(req, resp);
                    pw.println("Error occurred please talk to a representative");
                }
                else
                {
                    System.out.println("success on withdraw");
                    req.getRequestDispatcher("profile.html").include(req, resp);
                    pw.println("Success, here's your money");
                }
            }
            else
            {
                System.out.println("depositing");

                if (!new AccountController().deposit(Integer.parseInt(req.getParameter("depositAmount")), user.getId(), (Integer) req.getSession(false).getAttribute("accountType")) )
                {
                    System.out.println("Error occurred on deposit");
                    req.getRequestDispatcher("profile.html").include(req, resp);
                    pw.println("Error occurred with your deposit");
                }
                else
                {
                    System.out.println("Success on deposit");
                    resp.sendRedirect("profile");
                }
            }
        }

    }
}
