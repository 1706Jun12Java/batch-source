package com.revature.leibniz.ers.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		if(req.getSession().getAttribute("username") != null) {
			RequestDispatcher rd = req.getRequestDispatcher("employee");
			rd.forward(req, resp);
		}
		else {
			
		}
		
	}
}
