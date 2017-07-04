package com.jdbcbank.controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Properties;

import javax.servlet.*;
import javax.servlet.http.*;

import com.jdbcbank.domain.SuperUser;
import com.jdbcbank.domain.User;


public class LoginServlet extends HttpServlet {

	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		HttpSession session = req.getSession();
 
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password"); 
		
		try {
			MessageDigest digest;
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
			password = Base64.getEncoder().encodeToString(hash); 
			
		} catch (NoSuchAlgorithmException e1) {
			 
			e1.printStackTrace();
		} 
		
		User u = new User(username, password);
		
		if ( SuperUser.isSuperUser(u)){
			pw.println("Welcome, "+username);
			
			session.setAttribute("username", u.getUser_username());
			session.setAttribute("userid", u.getUser_id());
			session.setAttribute("error",null);
			resp.sendRedirect("profile_super");
			
		} else
			try {
				if (u.userLogin()){
					pw.println("Welcome, "+username);

					session.setAttribute("username", u.getUser_username());
					session.setAttribute("userid", u.getUser_id());
					session.setAttribute("error",null);
					resp.sendRedirect("profile.html");
				}
				else {
					session.setAttribute("error", "Login Error: Incorrect Username or Password");
					resp.sendRedirect("./");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}

}
