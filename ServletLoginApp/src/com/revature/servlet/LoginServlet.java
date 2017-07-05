package com.revature.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{

	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		

		HttpSession session = req.getSession(true);
		
		pw.println(req.getParameter("incorrect"));
		String wasIncorrect=(String) session.getAttribute("incorrect");
		if(wasIncorrect!=null){
			pw.println(wasIncorrect);
		}
		req.getRequestDispatcher("login.html").include(req, res);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
	
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		

		HttpSession session = req.getSession();
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if(password.equals("password123")){
			pw.println("Welcome, "+username);
			session.setAttribute("username", username);
			res.sendRedirect("profile");
		}
		else{
			session.setAttribute("incorrect", "inccorect password");
			res.sendRedirect("login");
		}
	}
}
