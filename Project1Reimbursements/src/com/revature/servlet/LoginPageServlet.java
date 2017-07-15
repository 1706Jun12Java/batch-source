package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginPageServlet extends HttpServlet {

	public LoginPageServlet() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
	 * ServletException, IOException {
	 * 
	 * }
	 * 
	 * protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	 * throws ServletException, IOException { }
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		
		req.getRequestDispatcher("load/top.html").include(req, resp);
		String wasIncorrect = (String) session.getAttribute("incorrect");
		if (wasIncorrect != null) {
			pw.println("<h3 class='error'>"+wasIncorrect+"</h3");
		}
		req.getRequestDispatcher("load/login.html").include(req, resp);
		req.getRequestDispatcher("load/bot.html").include(req, resp);
		session.setAttribute("incorrect", null);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
