package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserSessionImpl;
import com.bank.user.Users;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		
		String wasIncorrect = (String) session.getAttribute("incorrect");

		req.getRequestDispatcher("header.html").include(req, resp);

		if (wasIncorrect != null){
			pw.println("<div class=\"container\"> <p style=\"text-align: center; color:red; \">" + wasIncorrect + "</p> </div>");
		}
		
		Users user = (Users) session.getAttribute("user");

		if (user == null){
			req.getRequestDispatcher("login.html").include(req, resp);
			
			req.getRequestDispatcher("footer.html").include(req, resp);

		} else {
			resp.sendRedirect("profile");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		UserSessionImpl loginUser = new UserSessionImpl();
		
		loginUser.login(username,password);
		
		
		if (loginUser.isOnline()){
			pw.println("Welcome, "+ loginUser.getUser().getUsername());
			
			session.setAttribute("user", loginUser.getUser());
			
			session.setAttribute("incorrect",null);
			loginUser = null;
			
			resp.sendRedirect("profile");
			
		} else {
			session.setAttribute("incorrect", "The information you enter did not match any account!");
			resp.sendRedirect("login");
		}
	}

}
