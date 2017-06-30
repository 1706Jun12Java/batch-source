package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5273205746798490620L;

	public LogoutServlet() {
		// TODO Auto-generated constructor stub
	}


	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		req.getRequestDispatcher("link.html").include(req, resp);
		HttpSession session = req.getSession();
		session.invalidate();
		pw.println("you are successfully logged out");
		pw.println(session.getAttribute("username"));
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
	}
}
