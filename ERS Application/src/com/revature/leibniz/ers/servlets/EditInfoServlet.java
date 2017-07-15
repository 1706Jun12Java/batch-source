package com.revature.leibniz.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditInfoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {	
		myService(req, resp);
	}
	
	private void myService(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {	
		PrintWriter pw = resp.getWriter();
		pw.write("<!DOCTYPE html>"
				+ "<html>"
				+ "	<head>"
				+ "		<title>MAKE REIMBURSEMENT REQUEST</title>"
				+ "		<meta charset='utf-8'>"
				+ "		<link rel='stylesheet' href='./css/mystyle.css'>"
				+ "	</head>"
				+ "	<body>"
				+ "		<h1 class='title'>EDIT YOUR INFORMATION<h1>"
				+ "		<div class='xcontainer2'>"
				+ "			<form action='processUserInfo' method='post'>"
				+ "				<p class='label'>Firstname:</p><br>"
				+ "				<input name='firstname' class='textfield'>"
				+ "				<p class='label'>Lastname:</p><br>"
				+ "				<input name='lastname' class='textfield'>"
				+ "				<input type='submit' value='Submit changes' class='submitButton'>"
				+ "			</form>"
				+ "		</div>"
				+ "	</body>"
				+ "</html>"
				+ "");
		
	}
	
}
