package com.bankapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {

		/**
	 * 
	 */
	private static final long serialVersionUID = -7709717894635271706L;

		@Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
			
			HttpSession session = request.getSession(); 
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//PrintWriter pw = response.getWriter();

			if (TestClass.checkUser(username, password)) { // .equals(password)
				//pw.println("<p>hello, " + request.getParameter("username") + "</p>");
				session.setAttribute("username", username);
				response.sendRedirect("mainMenu.html");
			} else {
				response.sendRedirect("index.html");
			}
			
	        /*TestClass.checkUser(username,password)*/
			/*
			 * .equals(password)
			 */
	        
	      
	    }  
	

}
