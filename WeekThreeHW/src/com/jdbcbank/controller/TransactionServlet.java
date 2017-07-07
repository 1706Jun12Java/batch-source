package com.jdbcbank.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbcbank.domain.Account;
import com.jdbcbank.domain.OverdraftException;
 
@WebServlet(asyncSupported = true)
public class TransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   
		 System.out.println("tt");
		 //System.out.println(req.getParameter("account_id"));
		 int account_id = Integer.parseInt(req.getParameter("account_id"));
		 String transactionType = req.getParameter("transaction_type");
		 float amt = Float.parseFloat(req.getParameter("transaction_amt"));
		 
		 //System.out.println(account_id);
		 
		 Account a = new Account(account_id);
		 try{
			 switch (transactionType) {
			 case "withdraw":
				 a.withrawFromAccount(amt);
				 break;
			 case "deposit":
				 a.depositToAccount(amt);
				 break;
			 }
		 }catch(SQLException e){
			 e.printStackTrace();
		 } catch(OverdraftException e){
			 e.printStackTrace();
			 
		 }
		  
		 resp.sendRedirect("profile.html");
	}

}
