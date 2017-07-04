package com.jdbcbank.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.http.*;


public class LogoutServlet extends HttpServlet {

	public LogoutServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		pw.println("<p style=\"color:red; border: 1px solid powderblue; padding: 10px;  font-size: 150%; background-color: powderblue\" >you are successfully logged out</p>");
		req.getRequestDispatcher("index.html").include(req, resp);
		HttpSession session = req.getSession();
		session.invalidate();  
	}

}
