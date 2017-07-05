package com.revature.bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LogoutServlet extends HttpServlet{
	
	private static final long serialVersionUID = 5273205746798490620L;

	public LogoutServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("login.html");
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		doGet(req,resp);
	}
}
