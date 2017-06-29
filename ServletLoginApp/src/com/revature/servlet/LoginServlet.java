package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		String wasIncorrect = (String) session.getAttribute("incorrect");
		if (wasIncorrect != null){
			pw.println(wasIncorrect);
		}
		req.getRequestDispatcher("login.html").include(req, resp);
		
	}
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (password.equals("admin123")){
			pw.println("Welcome, "+username);
			
			session.setAttribute("username", username);
			session.setAttribute("incorrect",null);
			resp.sendRedirect("profile");
			
		} else {
			session.setAttribute("incorrect", "incorrect password");
			resp.sendRedirect("login");
		}
		
	}

}
