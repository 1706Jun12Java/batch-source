package com.revature.servlet;

import com.revature.DAO.AccountController;
import com.revature.DAO.UserController;
import com.revature.model.Account;
import com.revature.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by John on 6/30/2017.
 */
public class Profile extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        System.out.println("in profile get method");

        HttpSession session = req.getSession(false);

        if (session != null)
        {
            System.out.println("user is log in");
            User user = new UserController().getUserByUsername((String) session.getAttribute("username"));
            List<Account> accounts = new AccountController().getAccounts(user.getId());

            PrintWriter pw = res.getWriter();
            req.getRequestDispatcher("profile.html").include(req, res);

            pw.println("<form action=\"/profile\" method=\"post\">");
            for (Account acc : accounts)
            {
                String accountName;
                if (acc.getAccountType() == 1)
                    accountName = "Checking";
                else
                    accountName = "Savings";

                pw.println("<input type=\"radio\" name=\"account\" value=\"" + accountName + "\" > " + accountName +
                        " <br> Your balance is: " + acc.getBalance() + "<br>" );
            }

            pw.println("<br> <input type=\"radio\" name=\"account\" value=\"newAccount\">" + "Create new account" +
                    "<select name=\"accountType\">" +
                    "    <option value=\"1\">Checking</option>" +
                    "    <option value=\"2\">Savings</option>" +
                    "</select>" +
                    "<br><button>Submit</button>" +
                    "</form>");
        }
        else
        {
            System.out.println("session was null");
            res.sendRedirect("index.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        System.out.println("Enter profile post");
        PrintWriter pw = res.getWriter();
        HttpSession session = req.getSession(false);
        User user = new UserController().getUserByUsername((String) session.getAttribute("username"));

        if (req.getParameter("account").equals("newAccount"))
        {
            System.out.println("Entering new account. select has " + req.getParameter("accountType") );
            Account account = new AccountController().createAccount(user.getId(), Integer.parseInt(req.getParameter("accountType")));

            if (account == null)
            {
                System.out.println("Account is null");
                res.sendRedirect("profile");
            }
            else
            {
                System.out.println("Account created");
                req.getSession(false).setAttribute("accountType", account.getAccountType());

                req.getRequestDispatcher("account.html").include(req, res);

                pw.println("<p>Your balance: " + account.getBalance() + " </p>" +
                        "<form action=\"account\" method=\"post\">" +
                        "    <input type=\"radio\" name=\"withdraw\" value=\"\"> withdraw" +
                        "    <input type=\"text\" name=\"withdrawAmount\" value=\"\"><br><br>" +
                        "    <input type=\"radio\" name=\"deposit\" value=\"\"> deposit" +
                        "    <input type=\"text\" name=\"depositAmount\" value=\"\">" +
                        "     <button>submit</button>" +
                        "</form>");
            }
        }
        else
        {
            int accType;
            if (req.getParameter("account").toLowerCase().equals("checking"))
                accType = 1;
            else
                accType = 2;

            Account account = new AccountController().getAccountById(user.getId(), accType);
            req.getSession(false).setAttribute("accountType", account.getAccountType());


            req.getRequestDispatcher("account.html").include(req, res);

            pw.println("<p>Your balance: " + account.getBalance() + " </p>" +
                    "<form action=\"account\" method=\"post\">" +
                    "    <input type=\"radio\" name=\"withdraw\" value=\"\"> withdraw" +
                    "    <input type=\"text\" name=\"withdrawAmount\" value=\"\"><br><br>" +
                    "    <input type=\"radio\" name=\"deposit\" value=\"\"> deposit" +
                    "    <input type=\"text\" name=\"depositAmount\" value=\"\">" +
                    "     <button>submit</button>" +
                    "</form>");
        }
    }
}
