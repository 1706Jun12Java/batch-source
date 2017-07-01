package com.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {

		/**
	 * 
	 */
	private static final long serialVersionUID = -7709717894635271706L;

		@Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			PrintWriter pw = response.getWriter();

			// You should actually validate your passwords. But you get the point.
			if (username.equals("hello")) { // password
				pw.println("<p>hello, " + request.getParameter("username") + "</p>");
			} else {
				pw.println("<p>NO</p>");
			}
			pw.println("<a href=\"login.html\">go home</a>");

	        /*TestClass.checkUser(un,pw)*/
	        
	      
	    }  
	

}
