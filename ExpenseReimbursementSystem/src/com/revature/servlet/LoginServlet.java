package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UsersDaoImpl;
import com.revature.domain.Users;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UsersDaoImpl users = new UsersDaoImpl();
	
		String un = req.getParameter("username");
		String pw = req.getParameter("password");
		
		if(users.login(un, pw)){
			resp.sendRedirect("employee.html");
		}else{
			resp.sendRedirect("manager.html");	
		}
	}
}