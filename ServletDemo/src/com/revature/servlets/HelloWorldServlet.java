package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet{

	public HelloWorldServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		System.out.println("Did get");
		PrintWriter pw = resp.getWriter();
		pw.println("<p>hello, "+ req.getParameter("username") +"</p>");
		pw.println("<a href =\"index.html\">go home</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		PrintWriter pw = resp.getWriter();
		String num1 = req.getParameter("number1");
		String num2 = req.getParameter("number2");
		String op = req.getParameter("op");
		System.out.println(op);
		int realnum1 = Integer.parseInt(num1);
		int realnum2 = Integer.parseInt(num2);
		int result = 0;
		switch(op){
		case "+": result = realnum1 + realnum2;
		break;
		case "-": result = realnum1-realnum2;
		break;
		case "*": result = realnum1 * realnum2;
		break;
		case "/": result = realnum1/realnum2;
		}
		pw.println("<p> Your result is: " + result +"</p>");
		pw.println("<a href =\"index.html\">go home</a>");
	}

}
