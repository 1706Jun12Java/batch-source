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
		

		if(session != null) {
			try {
				User user = (User) session.getAttribute("user");

				pw.println("Hello, " + user.getUsername() + ". Welcome to your Profile.");
				pw.println("<div> <a href=\"account\"> view accounts </a> </div>");
				
				pw.println("<div> <a href=\"logout\"> logout</a> </div>");
				
				if (user.getSuperUser() > 0){
					   pw.print("<div> <p>Super user Action</p> </div>"
					   		+ "<form action=\"super\" action=\"get\">"
			            		+ "<select name=\"choice\"> "
			            		+ "<option value=\"view\" selected> View all users </option>"
								+ "<option value=\"delete\"> Delete All Users </option> "
			            		+ "<input type=\"submit\" value=\"Go\"></form> </div>");
				}
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
