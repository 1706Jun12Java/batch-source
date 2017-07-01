package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserDao;
import com.bank.dao.UserImpl;
import com.bank.user.Account;
import com.bank.user.User;

@SuppressWarnings("serial")
public class AccountServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		
		if(session != null){
			
			try {
				UserDao balance = new UserImpl();
				User user = (User) session.getAttribute("user");

				List<Account> accounts = balance.getAllBalances(user);
				
				if(accounts.isEmpty()){
					pw.println("You have no Accounts");
				} else {
					pw.println("<div> Your accounts are </div>");
					for (Account i: accounts) {
			            pw.print("<div> " + i.toString() + " ");
			            pw.print("<form action=\"remove\" action=\"get\">"
			            		+ "<input type=\"hidden\" name=\"accountNumber\" value=\"" + i.getAccountID() + "\" />"
			            		+ "<input type=\"submit\" value=\"Remove Account\"></input></form> </div>");
			        }
				}
				
				pw.println("<form action=\"balance\" method=\"get\">");
				
				pw.println("<input type=\"number\" placeholder=\"Account Number\" name=\"account\" >");
				pw.println("<input type=\"number\" placeholder=\"Amount\" name=\"money\" >");
				
				pw.println("<select name=\"choice\"> "
						+ "<option value=\"withdraw\" selected> withdraw </option>"
						+ "<option value=\"deposit\"> deposit </option> "
						+ "</select>");
				
				pw.println("<input type=\"submit\" >"
						+ "</form>");
				
				
				
				pw.println("<div> <a href=\"logout\"> logout</a> </div>");
				pw.println("<div> <a href=\"profile\"> Back to Profile</a> </div>");
				
				pw.println("<div> <a href=\"create\"> Create a account </a> </div>");
				
			} catch (Exception e){
				resp.sendRedirect("index.html");		
			}


			
		} else {
			resp.sendRedirect("index.html");		
		}
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
