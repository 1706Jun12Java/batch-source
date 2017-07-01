package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserDao;
import com.bank.dao.UserImpl;
import com.bank.user.User;

@SuppressWarnings("serial")
public class BalanceServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession(false);
		
		int money = 0;
		int account = 0;
		String choice = "";
		try {
			money = Integer.parseInt(req.getParameter("money")); 
			account = Integer.parseInt(req.getParameter("account"));
			choice = req.getParameter("choice");
			
		} catch (Exception e) {
			// TODO: handle exception
	        req.getRequestDispatcher("account");
		}
		

		User user = (User) session.getAttribute("user");
		
		System.out.println();
        UserDao userImpl = new UserImpl();

		if(session != null && choice.equals("withdraw")) {
        	userImpl.withdraw(user, account, money);
	        req.getRequestDispatcher("account");
		} else if (session != null && choice.equals("deposit")) {
        	userImpl.deposit(user, account, money);
	        req.getRequestDispatcher("account");
		}
		
		req.getRequestDispatcher("account").include(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
