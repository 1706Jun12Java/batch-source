package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserImpl;
import com.bank.user.User;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		
		String wasIncorrect = (String) session.getAttribute("incorrect");
		
		req.getRequestDispatcher("header.html").include(req, resp);

		if (wasIncorrect != null){
			pw.println(wasIncorrect);
		}
		
		User user = (User) session.getAttribute("user");

		if (user == null){
			req.getRequestDispatcher("register.html").include(req, resp);
			
			req.getRequestDispatcher("footer.html").include(req, resp);

		} else {
			resp.sendRedirect("profile");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		
		boolean create = new UserImpl().createUser(username, password, email);;
		
		if (create){
			session.setAttribute("succesfulRegister", "successful");
			resp.sendRedirect("login");
		} else {				
			session.setAttribute("incorrect", "username already used");
			resp.sendRedirect("register");
		}
		
	}

	
}
