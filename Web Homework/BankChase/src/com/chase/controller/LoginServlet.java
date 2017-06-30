package com.chase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chase.dao.LoginDaoImpl;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
	        throws ServletException, IOException {  
	  
	    response.setContentType("text/html");  
	    PrintWriter pw = response.getWriter();  
	          
	    String username =request.getParameter("username");  
	    String password =request.getParameter("password");  
	          
	    if(LoginDaoImpl.validate(username, password)){  
	    	HttpSession session=request.getSession();  
	        session.setAttribute("username",username); 
	        RequestDispatcher rd=request.getRequestDispatcher("profile.html");  
	        rd.forward(request,response);  
	    }  
	    else{  
	        
	        RequestDispatcher rd=request.getRequestDispatcher("login.html");  
	        rd.include(request,response);  
	        pw.println("Invalid Username or Password");
	    }  
	          
	    pw.close();  
	    }  
	}  

