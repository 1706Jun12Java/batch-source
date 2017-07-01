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
	        response.setContentType("text/html;charset=UTF-8");
	        
	        PrintWriter out = response.getWriter();
	        
	        String un = request.getParameter("username");
	        String pw = request.getParameter("password");
	        
	       
	       if(TestClass.checkUser(un,pw))
	        {	
	        	RequestDispatcher rs = request.getRequestDispatcher("Welcome");
	            rs.forward(request, response);
	        	
	        }
	        else
	        {
	           out.println("Username or Password incorrect");
	           RequestDispatcher rs = request.getRequestDispatcher("index.html");
	           rs.include(request, response);
	        }
	    }  
	

}
