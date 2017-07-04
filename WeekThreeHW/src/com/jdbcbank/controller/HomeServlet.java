package com.jdbcbank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomeServlet extends HttpServlet {

	public HomeServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false); 
		 
		if(session != null){ 
			String error = (String) session.getAttribute("error");
			if (error != null){
				pw.println("<p style=\"color:red; border: 1px solid powderblue; padding: 10px;  font-size: 150%; background-color: powderblue\" >" + error + "</p>");
			}  
		} 
		 
		req.getRequestDispatcher("index.html").include(req, resp);  
		
	}
}


