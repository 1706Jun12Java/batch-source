package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.domain.Account;
import com.revature.domain.TransLog;
import com.revature.domain.User;
import com.revature.main.ActionCaller;

public class SignedInServlet extends HttpServlet {

	public SignedInServlet() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		doPost(req,resp);
		

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		req.getRequestDispatcher("Navbar.html").include(req, resp);
		HttpSession sess =req.getSession(false);
		User user = (User) sess.getAttribute("user");
		if(user!=null){
			try {
				pw.println("<div class=\"panel panel-default\"> \n <div class=\"panel-heading\">\n <h2 class=\"panel-title\">Bank Accounts</h2> \n </div>");
				List<Account> accounts = ActionCaller.showAccounts(user);
				if(!accounts.isEmpty()){
					pw.println("<div class=\"table-responsive\">\n <table class=\"table\">");
					pw.println("<thead><tr><th>Account ID</th> <th>Account Type</th> <th>Account Balance</th>   </tr> </thead>");
					pw.println("<tbody>");
					for(Account account :accounts){
						pw.println("<tr>");
						pw.println("<td>"+account.getAccountID()+"</td>");
						pw.println("<td>"+account.getAccountType()+"</td>");
						pw.println("<td>"+account.getBalance()+"</td>");
						pw.println("<td><a href=\"delete?id="+account.getAccountID()+"\" class=\"confirm-delete btn mini red-stripe\" role=\"button\" data-title=\"DELETE\">Delete</a></td>");
						pw.println("</tr>");
					}
					pw.println(" </table> </div>");
					
				}
				pw.println("</div>");
				
				pw.println("<div class=\"panel panel-default\"> \n <div class=\"panel-heading\">\n <h2 class=\"panel-title\">Create New Account</h2> \n </div>");
				pw.println("<div class = \"panel-body\"> \n");
				pw.println("<form action=\"createBankAccount\" method=\"post\">");
				pw.println("<label class=\"radio-inline\"><input type=\"radio\" value=\"checking\" name=\"optradio\">Checking</label><label class=\"radio-inline\"><input type=\"radio\" value=\"saving\" name=\"optradio\">Saving</label><br>");
				pw.println("<input type=\"submit\" value=\"Create\">");
				pw.println("</form>");
				pw.println("</div>");
				pw.println("</div>");
				
				pw.println("<div class=\"panel panel-default\"> \n <div class=\"panel-heading\">\n <h2 class=\"panel-title\">Deposit/Withdraw From Account</h2> \n </div>");
				pw.println("<div class = \"panel-body\"> \n");
				pw.println("<form action=\"depositwithdraw\" method=\"post\">");
				pw.println("<label class=\"radio-inline\"><input type=\"radio\" value=\"deposit\" name=\"optradio2\">Deposit</label><label class=\"radio-inline\"><input type=\"radio\" value=\"withdraw\" name=\"optradio2\">Withdraw</label><br>");
				pw.println("<fieldset> Account ID <input type=\"text\" name=\"ID\"><br> <br>Amount   $ <input type=\"text\" name=\"amount\"></fieldset>");
				pw.println("<input type=\"submit\" value=\"Submit\">");
				pw.println("</form>");
				pw.println("</div>");
				pw.println("</div>");
				
				pw.println("<div class=\"panel panel-default\"> \n <div class=\"panel-heading\">\n <h2 class=\"panel-title\">Transaction Log</h2> \n </div>");
				try {
					List<TransLog> logs = ActionCaller.showHistory(user);
					if(!logs.isEmpty()){
						pw.println("<div class=\"table-responsive\">\n <table class=\"table\">");
						pw.println("<thead><tr><th>Log ID</th> <th>Account ID</th> <th>Amount Changed</th>   </tr> </thead>");
						pw.println("<tbody>");
						for(TransLog log :logs){
							pw.println("<tr>");
							pw.println("<td>"+log.getLogID()+"</td>");
							pw.println("<td>"+log.getAccountID().getAccountID()+"</td>");
							pw.println("<td>"+log.getUpdate()+"</td>");
							pw.println("</tr>");
						}
						pw.println(" </table> </div>");
					}
				} catch (InvalidUsernameException | InvalidAccountException e) {
					// TODO Auto-generated catch block
					pw.println("<div class = \"panel-body\"> \n"+e.getMessage()+"</div>");
					pw.println("</div>");
				}
				pw.println("</div>");
			} catch (InvalidUsernameException | InvalidAccountException e) {
				pw.println("<div class = \"panel-body\"> \n"+e.getMessage()+"</div>");
				pw.println("</div>");
			}
		}else{
			resp.sendRedirect("404.html");
		}
		
	}
}
