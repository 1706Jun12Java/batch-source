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

            for (Account acc : accounts)
            {
                String accountName;
                if (acc.getAccountType() == 1)
                    accountName = "Checking";
                else
                    accountName = "Savings";

                pw.println("<p>" + accountName + " \nYour balance is: " + acc.getBalance() + "</p>");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        super.doPost(req, res);
    }
}
