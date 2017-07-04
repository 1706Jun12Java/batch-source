package com.jdbcbank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.*;
import javax.servlet.http.*;

import com.jdbcbank.domain.User;

public class RegisterServlet extends HttpServlet {

	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();

		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String password_confirm = req.getParameter("password_confirm");

		if (!password_confirm.equals(password)) {
			session.setAttribute("error", "Register Error: Password Entered Are Not The Same");
			resp.sendRedirect("./");
		} else{
			try {

				MessageDigest digest;
				digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
				password = Base64.getEncoder().encodeToString(hash);

				User u = new User(username, password, email);
				System.out.println(password);
				
				if (u.userNameExist()) {
					session.setAttribute("error", "Register Error: Username already exists");
					resp.sendRedirect("./");
				} else {
					u.createUserToDB();

					//System.out.println(username);
					//System.out.println(password);

					pw.println("Welcome, " + username);
					session.setAttribute("username", u.getUser_username()); 
					session.setAttribute("userid", u.getUser_id()); 
					session.setAttribute("error", null);
					resp.sendRedirect("profile.html");
				}

			} catch (NoSuchAlgorithmException e1) {

				e1.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
}
