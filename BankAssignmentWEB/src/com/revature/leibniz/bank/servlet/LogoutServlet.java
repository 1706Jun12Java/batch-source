package com.revature.leibniz.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws IOException, ServletException {
		HttpSession session = req.getSession();
		session.invalidate();
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<h2>Logout Successful: Thank you for using LENNYBANK, </h2><br>");
		pw.println("<h3><a href =\"index.html\">GO BACK</a></h3>");
	}
}
