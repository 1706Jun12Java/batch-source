package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;

public class DeleteAccountServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		
		BigDecimal balance = (BigDecimal) session.getAttribute("bankAccountBalance");
		
		if(session!=null && (balance.compareTo(BigDecimal.valueOf(0))==0)){
		int userId = (int) session.getAttribute("userId");
		int acctId = (int) session.getAttribute("acctId");
		BankAccountDao baid = new BankAccountDaoImpl();
		baid.deleteBankAccount(userId, acctId);
		pw.println(baid.deleteBankAccount(userId, acctId));
		resp.sendRedirect("accounts");
		}
		else {
			resp.sendRedirect("accounts");
		}

		
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
	}

}
