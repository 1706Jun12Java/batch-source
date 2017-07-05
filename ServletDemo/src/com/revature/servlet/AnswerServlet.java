package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AnswerServlet extends HttpServlet{

	public AnswerServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String answer = (String) req.getAttribute("answerServlet");
		pw.println("<p>the answer is "+answer+"</p>");
		pw.println("<a href=\"calc.html\">MOAR NUMBERS PLEASE</a>");
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String answer = (String) req.getAttribute("answerServlet");
		pw.println("<p>the answer is "+answer+"</p>");
		pw.println("<a href=\"calc.html\">MOAR NUMBERS PLEASE</a>");
		
	}
}
