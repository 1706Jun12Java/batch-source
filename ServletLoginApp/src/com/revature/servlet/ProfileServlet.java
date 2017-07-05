package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet{

	public ProfileServlet() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		if(session!=null){
			String username = (String) session.getAttribute("username");
			pw.println("Hello, "+username+". Welcome to your Profile.");
		} else {
			pw.println("please login first");
			req.getRequestDispatcher("login").include(req, resp);
		}
	
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
	
	}
}
