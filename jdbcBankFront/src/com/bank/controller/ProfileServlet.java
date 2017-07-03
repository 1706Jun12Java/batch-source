package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.user.User;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ProfileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		
		req.getRequestDispatcher("index.html").include(req, resp);

		if(session != null) {
			try {
				User user = (User) session.getAttribute("user");

				pw.println("<div class=\"jumbotron container\">");
		
				pw.println("<p> Hello, " + user.getUsername() + ". Welcome to your Profile. </p>");
				
				pw.println("<div class=\"btn-group\">");

				pw.println("<button type=\"button\"class=\"btn btn-default\"> <a href=\"account\"> view accounts </a> </button>");
				pw.println("<button type=\"button\"class=\"btn btn-danger\"> <a href=\"logout\"> logout</a> </button>");
				pw.println("</div>");

				if (user.getSuperUser() > 0){
					   pw.print("<div> <p>Super user Action</p> </div>"
					   		+ "<form action=\"super\" action=\"get\">"
			            		+ "<select name=\"choice\"> "
			            		+ "<option value=\"view\" selected> View all users </option>"
								+ "<option value=\"delete\"> Delete All Users </option> "
			            		+ "<input type=\"submit\" value=\"Go\"></form> </div>");
				}
				
				pw.println("</div>");
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
	}

}
