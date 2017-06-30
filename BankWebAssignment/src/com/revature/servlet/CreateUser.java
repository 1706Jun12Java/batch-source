package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Exceptions.InvalidPasswordException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.domain.User;
import com.revature.main.ActionCaller;

public class CreateUser extends HttpServlet {

	public CreateUser() {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();	
		HttpSession sess =req.getSession();
		User user = (User) sess.getAttribute("user");
		
		if(user!=null){
			req.getRequestDispatcher("Navbar.html").include(req, resp);
			try {
				ActionCaller.createAccount(req.getParameter("username"), req.getParameter("password"));
				pw.println("Successfully Created Account");
				req.getRequestDispatcher(req.getRequestURI()).include(req, resp);
			} catch (InvalidUsernameException | InvalidPasswordException e) {
				// TODO Auto-generated catch block
				req.getRequestDispatcher("404.html").include(req, resp);
				pw.println(e.getMessage());
			}
		} else {
			try {
				ActionCaller.createAccount(req.getParameter("username"), req.getParameter("password"));
				pw.println("Successfully Created Account");
				req.getRequestDispatcher("LogIn.html").include(req, resp);
			} catch (InvalidUsernameException | InvalidPasswordException e) {
				req.getRequestDispatcher("404.html").include(req, resp);
				pw.println(e.getMessage());
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		doGet(req,resp);
	}
}
