package com.revature.leibniz.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MakeRRServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.write("<!DOCTYPE html>"
				+ "<html>"
				+ "	<head>"
				+ "		<title>MAKE REIMBURSEMENT REQUEST</title>"
				+ "		<meta charset='utf-8'>"
				+ "		<link rel='stylesheet' href='./css/mystyle.css'>"
				+ "	</head>"
				+ "	<body>"
				+ "		<h1 class='title'>Submit Reimbursement Request<h1>"
				+ "		<div class='xcontainer2'>"
				+ "			<form action='processRR' method='post'>"
				+ "				<p class='label'>quantity:</p><br>"
				+ "				<input name='quantity' class='textfield'>"
				+ "				<p class='label'>Upload image(optional):</p><br>"
				+ "				<input type='file' name='quantity' class='textfield'>"
				+ "				<input type='submit' value='Submit request' class='submitButton'>"
				+ "			</form>"
				+ "		</div>"
				+ "	</body>"
				+ "</html>"
				+ "");
		
	}
}
