package com.jdbcbank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jdbcbank.domain.Account; 
import com.jdbcbank.domain.Transaction;
import com.jdbcbank.domain.TransactionBalance;
import com.jdbcbank.domain.User;

public class ProfileServlet extends HttpServlet {

	public ProfileServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		 
		HttpSession session = req.getSession(false);
		if(session!=null){ 
			resp.setContentType("application/json");
			PrintWriter pw = resp.getWriter();
			int userID = (int) session.getAttribute("userid");
			String username = (String) session.getAttribute("username");
			//pw.println("Hello, "+userID+ " "+username+". Welcome to your Profile.");
			System.out.println();
			User u = new User(userID);
			try {
				List<Account> listAccounts = u.getUserAccount();
				//System.out.println(listAccounts);
				System.out.println(listAccounts);
					
				
				HashMap<Integer, TransactionBalance>  account_transation = new HashMap<Integer, TransactionBalance>();
				
				for (Account a : listAccounts){
					
						account_transation.put(a.getAccount_id(), new TransactionBalance(a.getBalance(), a.getListTransaction()));
					 
				}
				//System.out.println(account_transation);
				
				ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(new JsonEveryThing(username,account_transation));
				//System.out.println(json);
				pw.print(json); 
			
			}catch(SQLException e){
				e.printStackTrace();
			}
			  
			
		} else {
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			pw.println("<p style=\"color:red; border: 1px solid powderblue; padding: 10px;  font-size: 150%; background-color: powderblue\" >please login first</p>");
			req.getRequestDispatcher("index.html").include(req, resp); 
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}


