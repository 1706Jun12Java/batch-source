package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

	public CalculatorServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String n1 = req.getParameter("n1");
		String n2 = req.getParameter("n2");
		String operation = req.getParameter("operation");
	
		String answer = "";
		try {
			Double first = Double.parseDouble(n1);
			Double second = Double.parseDouble(n2);
			switch (operation){
			case "add": answer = "the answer is: "+(first+second);
				break;
			case "subtract" : answer = "the answer is: "+(first-second);
				break;
			case "multiply" : answer = "the answer is: "+(first*second);
				break;
			case "divide" : answer = "the answer is: "+(first/second);
				break;
			default: answer = "invalid operation";
			}
		} catch (Exception e){
			answer = "invalid number or operation";
		}
		req.setAttribute("answer", answer);
		
		RequestDispatcher rd = req.getRequestDispatcher("answer");
		rd.forward(req, resp);
		/* 
		resp.sendRedirect("answer"); */
		
		
	}

}
