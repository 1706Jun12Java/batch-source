package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class HelloWorldServlet extends HttpServlet {

	public HelloWorldServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// we would not use GET for login.
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter pw = resp.getWriter();

		// You should actually validate your passwords. But you get the point.
		if (username.equals(password)) {
			pw.println("<p>hello, " + req.getParameter("username") + "</p>");
		} else {
			pw.println("<p>NO</p>");
		}
		pw.println("<a href=\"HelloWorld.html\">go home</a>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter pw = resp.getWriter();

		// You should actually validate your passwords. But you get the point.
		if (username.equals(password)) {
			pw.println("<p>hello, " + req.getParameter("username") + "</p>");
		} else {
			pw.println("<p>NO</p>");
		}
		pw.println("<a href=\"HelloWorld.html\">go home</a>");

	}

}
