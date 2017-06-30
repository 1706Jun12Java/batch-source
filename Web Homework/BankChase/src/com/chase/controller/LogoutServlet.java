package com.chase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter pw = response.getWriter();  
          
        request.getRequestDispatcher("link.html").include(request, response);  
          
        HttpSession session = request.getSession();  
        session.invalidate();  
        pw.print("You are successfully logged out!");  
        HttpSession session2 = request.getSession(false); 
        
          if(session2!=null){
        	  request.getRequestDispatcher("link.html").include(request, response);
          }
          else {
        	  request.getRequestDispatcher("MainPage.htl").include(request, response);
        	  pw.print("Your already logged out!");
          }
        pw.close(); 
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

}
