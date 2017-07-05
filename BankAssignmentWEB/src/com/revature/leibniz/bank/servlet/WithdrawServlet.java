package com.revature.leibniz.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.leibniz.bank.util.DataUtil;
import com.revature.leibniz.bank.util.UpdateUtil;

public class WithdrawServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		// get withdrawValue
		double withdrawValue = Double.parseDouble(req.getParameter("withdrawValue"));
		
		// get accountID
		int accountID = DataUtil.accountID;
		
		// get balance
		double balance = DataUtil.balance;
		
		// check whether user is allow to withdraw
		boolean allowToWithdraw = (withdrawValue <= balance);
		
		
		if(allowToWithdraw) {
			double newBalance = balance - withdrawValue;
			UpdateUtil.updateAccountBalance(accountID, newBalance);
			
			pw.println("<h2>WITHDRAWL SUCCESSFUL</h2>");
			pw.println("<h3>Previous Balance: $" + balance + "</h3>");
			pw.println("<h3>Withdraw quantity: $" + withdrawValue + "</h3>");
			pw.println("<h3>New Balance: $" + newBalance + "</h3><br>");
			pw.println("<h3><a href= \"index.html\">Go Back</a></h3>");	
		}
		else {
			pw.println("<h2>WITHDRAWL DENIED</h2>");
			pw.println("<h3>Error: INSUFFICIENT BALANCE</h3><br>");
			pw.println("<h3><a href= \"index.html\">Go Back</a></h3>");

		}
		
		
	}

}
