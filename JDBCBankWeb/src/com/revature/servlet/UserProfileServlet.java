package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.domain.BankAccount;

public class UserProfileServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		if(session!=null){
			String username = (String) session.getAttribute("username");
			int userId = (int) session.getAttribute("userId");

			pw.println("<h2>Hello, "+ username + "</h2>");
			
			BankAccountDao baid = new BankAccountDaoImpl();
			pw.println("<head> <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\"><meta charset=\"UTF-8\"><title>Home Page</title></head>");
			pw.println("<h3>Bank Accounts</h3>");

			for(BankAccount bai: baid.getBankAccountList(userId)){
				
//				pw.print("<p>Account ID: <a href=\"BankAccountServlet\">" + bai.getBankAccountId() + "</a></p>" +		
//			"&emsp; &emsp; &emsp; &emsp;  Account Balance: " + bai.getBankAccountBalance() + "</p>");
				
				pw.println("<p>Account ID:" + bai.getBankAccountId() + "&emsp; &emsp; &emsp; &emsp;" + bai.getBankAccountBalance() + "</p>");
				
				int bankAccountId = (int) session.getAttribute("bai.getBankAccountId()");
				int bankAccountBalance = (int) session.getAttribute("bai.getBankAccountBalance()");
			}
			

		}
	}
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
	}

}