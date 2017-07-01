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
public class CreateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession(false);
		

		if(session != null) {
			
			try {
				User user = (User) session.getAttribute("user");

		        UserDao userImpl = new UserImpl();
		        userImpl.createAccount(user);

				
				resp.sendRedirect("account");
			} catch (Exception e) {
				// TODO: handle exception
				resp.sendRedirect("account");
			}

		} else {
			resp.sendRedirect("account");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
