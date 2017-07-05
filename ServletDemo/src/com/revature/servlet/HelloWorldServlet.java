package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloWorldServlet extends HttpServlet {
	public HelloWorldServlet(){
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
			System.out.println("did get");//on java side
			PrintWriter pw=resp.getWriter();
			
			
			String username=req.getParameter("username");

			String password=req.getParameter("password");
				
			if(username.equalsIgnoreCase(password)){
				pw.println("<p>Hello, "+req.getParameter("username") + "</p>");
			}
			else{
				pw.println("<p>NO</p>");
			}
			
			//PrintWriter writes directly to the response page
			pw.println("<a href=\"HelloWorld.html\"> go home</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
			System.out.println("did get");//on java side
			PrintWriter pw=resp.getWriter();
			
			
			String username=req.getParameter("username");

			String password=req.getParameter("password");
				
			if(username.equalsIgnoreCase(password)){
				pw.println("<p>Hello, "+req.getParameter("username") + "</p>");
			}
			else{
				pw.println("<p>NO</p>");
			}
			
			//PrintWriter writes directly to the response page
			pw.println("<a href=\"HelloWorld.html\"> go home</a>");
	}
}
