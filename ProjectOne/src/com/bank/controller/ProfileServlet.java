package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.user.Users;


@SuppressWarnings("serial")
public class ProfileServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		
		req.getRequestDispatcher("header.html").include(req, resp);

		if(session != null) {
			try {
				Users user = (Users) session.getAttribute("user");

				pw.println("<div class=\"jumbotron container\">");
		
					pw.println("<p> Hello " + user.getRole() +" " + user.getUsername() + ", Welcome to your Profile. </p>");
				
						if (user.getRole().equals("Manager")){
							pw.println("<button type=\"button\" class=\"btn btn-primary\" \"> <a href=\"view\" style=\"color: white\"> View All Employees </a> </button>");
						}
					
						pw.println("<button type=\"button\" class=\"btn btn-primary\" \"> <a href=\"information\" style=\"color: white\"> View Information </a> </button>");

						pw.println("<button type=\"button\" class=\"btn btn-primary\" \"> <a href=\"reimbursement\" style=\"color: white\"> Reimbursements  </a> </button>");
				
				pw.println("</div>");
				req.getRequestDispatcher("footer.html").include(req, resp);
			} catch (Exception e) {
				resp.sendRedirect("login");
			}

		} else {
			resp.sendRedirect("login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
