package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class RegisterServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6106882776099011295L;
	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		String wasIncorrect = (String) session.getAttribute("incorrect");
		if (wasIncorrect != null){
			pw.println(wasIncorrect);
		}
		req.getRequestDispatcher("register.html").include(req, resp);
	}
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{

		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");		
		String username = req.getParameter("reg_username");
		String password = req.getParameter("reg_password");
		String confirmPassword = req.getParameter("reg_password_confirm");
		if(!password.equals(confirmPassword)){
			session.setAttribute("incorrect", "password don't match");
			resp.sendRedirect("register");
		}else{
			UserDao UD = new UserDaoImpl();
			User newUser = new User(username, password);
			try{
				UD.createUser(newUser);
				resp.sendRedirect("login");
			}catch (Exception e){
				e.printStackTrace();
				session.setAttribute("incorrect", e.toString());
				resp.sendRedirect("register");
			}

		}
	}
}
