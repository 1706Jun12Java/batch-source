package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.UsersDaoImpl;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
	    PrintWriter out = resp.getWriter(); 
		String un = req.getParameter("username");
		String pw = req.getParameter("password");
		UsersDaoImpl ud = new UsersDaoImpl();
		if (ud.login(un, pw)) {
			RequestDispatcher rd = req.getRequestDispatcher("profile.html");
			rd.forward(req, resp);
		} else {
			out.println("Sorry username or password error");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
		out.close();
	}
}