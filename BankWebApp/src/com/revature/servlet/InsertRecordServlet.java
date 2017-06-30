package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertRecordServlet extends HttpServlet{

	public InsertRecordServlet() {
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = req.getParameter("userid");
		String fname = req.getParameter("firstname");
		String lname = req.getParameter("lastname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter pw = resp.getWriter();

		// You should actually validate your passwords. But you get the point.
		if (!username.equals(password)) {
			pw.println("<p>hello, " + req.getParameter("firstname") + "</p>");
		} else {
			pw.println("<p>NO</p>");
		}
		pw.println("<a href=\"index.html\">go home</a>");
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userid = req.getParameter("userid");
		String fname = req.getParameter("firstname");
		String lname = req.getParameter("lastname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter pw = resp.getWriter();

		// You should actually validate your passwords. But you get the point.
		if (!username.equals(password)) {
			pw.println("<p>hello, " + req.getParameter("firstname") + "</p>");
		} else {
			pw.println("<p>NO</p>");
		}
		req.setAttribute("C_ID", userid);
		req.setAttribute("C_FIRSTNAME", fname);
		req.setAttribute("C_LASTNAME", lname);
		req.setAttribute("C_USERNAME", username);
		req.setAttribute("C_PASSWORD", password);
		
		RequestDispatcher rd1 = req.getRequestDispatcher("C_ID");
		rd1.forward(req, resp);
		RequestDispatcher rd2 = req.getRequestDispatcher("C_FIRSTNAME");
		rd2.forward(req, resp);
		RequestDispatcher rd3 = req.getRequestDispatcher("C_LASTNAME");
		rd3.forward(req, resp);
		RequestDispatcher rd4 = req.getRequestDispatcher("C_USERNAME");
		rd4.forward(req, resp);
		RequestDispatcher rd5 = req.getRequestDispatcher("C_PASSWORD");
		rd5.forward(req, resp);
		
		pw.println("<a href=\"index.html\">go home</a>");
	}

}
