package com.chase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
		    throws ServletException, IOException {  
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter(); 
          
        HttpSession session = request.getSession(false);  
        if(session!=null){  
        session.getAttribute("username"); 
        request.getRequestDispatcher("profile.jsp").include(request, response); 
        }  
        else{  
        	 
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
		

	public void doPost(HttpServletRequest request, HttpServletResponse response)  
		    throws ServletException, IOException {         
		      
		    } 
}
