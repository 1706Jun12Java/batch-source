package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserImpl;
import com.bank.user.Users;

@SuppressWarnings("serial")
public class InformationServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {	
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		
		req.getRequestDispatcher("header.html").include(req, resp);

		if(session != null) {
			try {
				Users currentUser = (Users) session.getAttribute("user");
				
				pw.println("<div class=\"container\">");
					pw.println("<div>");
						pw.println("<div class=\"row\">");
							pw.println("<div class=\"col-md-offset-4 col-md-4 col-lg-4\">");
								pw.println("<p> " + currentUser.getRole() + " " + currentUser.getUsername() + ", </p>");
							pw.println("</div>");
						pw.println("</div>");

						pw.println("<form action=\"information\" method=\"POST\">");
							pw.println("<div class=\"row\">");
								pw.println("<div class=\"col-md-offset-4 col-md-4 col-lg-4\">");
									pw.println("<label for=\"firstname\"> First Name</label>");
									pw.println("<input name=\"firstname\" required placeholder=\"First Name\" value=\"" + currentUser.getFirstName() + "\" class=\"form-control\" type=\"text\">");
								pw.println("</div>");
							pw.println("</div>");
							pw.println("<div class=\"row\">");
								pw.println("<div class=\"col-md-offset-4 col-md-4 col-lg-4\">");
									pw.println("<label for=\"lastname\"> Last Name </label>");
									pw.println("<input name=\"lastname\" required placeholder=\"Last Name\" value=\"" + currentUser.getLastName() + "\" class=\"form-control\" type=\"text\">");
								pw.println("</div>");
							pw.println("</div>");
							pw.println("<div class=\"row\">");
								pw.println("<div class=\"col-md-offset-4 col-md-4 col-lg-4\">");
									pw.println("<label for=\"email\"> Email </label>");
									pw.println("<input name=\"email\" required placeholder=\"Email\" value=\"" + currentUser.getEmail() + "\" class=\"form-control\" type=\"email\">");
								pw.println("</div>");
							pw.println("</div>");
							pw.println("<div class=\"row\">");
								pw.println("<div class=\"col-md-offset-4 col-md-4 col-lg-4\">");
									pw.println("<label for=\"password\"> Password </label>");
									pw.println("<input name=\"password\" placeholder=\"Password\" class=\"form-control\" type=\"password\">");
								pw.println("</div>");
							pw.println("</div>");
							pw.println("<br>");
							pw.println("<div class=\"row\">");
								pw.println("<div class=\"col-md-offset-4 col-md-4 col-lg-4\">");
					      			pw.println("<button class=\"btn btn-primary btn-block btn-lg\" name=\"route\" value=\"information\">Update Info</button>");
								pw.println("</div>");
							pw.println("</div>");
						pw.println("</form>");
					pw.println("</div>");
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
		HttpSession session = req.getSession();
		
		
		if(session != null) {
			Users currentUser = (Users) session.getAttribute("user");

			String firstname = req.getParameter("firstname");
			String lastname = req.getParameter("lastname");
			String email = req.getParameter("email");
			
			String password = req.getParameter("password");
			
			if (new UserImpl().updateUser(currentUser.getU_ID(), firstname, lastname, email, password)){
				Users user = (Users) session.getAttribute("user");

				Users updatedUser = new UserImpl().getUserById(user.getU_ID());
				
				session.setAttribute("user", updatedUser);
			}
			
			
		} else {
			resp.sendRedirect("login");
		}
		
		resp.sendRedirect("profile");
	}
	
}
