package com.revature.leibniz.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.leibniz.bank.util.DataUtil;
import com.revature.leibniz.bank.util.UpdateUtil;

public class DepositServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		// get withdrawValue
		double depositValue = Double.parseDouble(req.getParameter("depositValue"));
		
		// get accountID
		int accountID = DataUtil.accountID;
		
		// get balance
		double balance = DataUtil.balance;
		
		double newBalance = balance + depositValue;
		UpdateUtil.updateAccountBalance(accountID, newBalance);
		
		pw.println("<h2>DEPOSIT SUCCESSFUL</h2>");
		pw.println("<h3>Previous Balance: $" + balance + "</h3>");
		pw.println("<h3>Deposit quantity: $" + depositValue + "</h3>");
		pw.println("<h3>New Balance: $" + newBalance + "</h3><br>");
		pw.println("<h3><a href= \"index.html\">Go Back</a></h3>");	
		
		
	}
}
