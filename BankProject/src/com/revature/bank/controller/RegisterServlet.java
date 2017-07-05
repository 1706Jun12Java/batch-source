package com.revature.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.bank.dao.UserDao;
import com.revature.bank.dao.UserDaoImpl;
import com.revature.bank.domain.User;
import com.revature.bank.exception.UniqueIDException;

public class RegisterServlet extends HttpServlet{

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
			pw.println("<h3 style=\"text-align:center;color:red;\">"+wasIncorrect+"</h3>");
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
			session.setAttribute("incorrect", "passwords don't match");
			resp.sendRedirect("register");
		}else{
			UserDao UD = new UserDaoImpl();
			User newUser = new User(username, password);
			try{
				UD.createUser(newUser);
				session.setAttribute("incorrect", null);
				resp.sendRedirect("login");
			}catch (UniqueIDException e){
				session.setAttribute("incorrect", "user already exist");
				resp.sendRedirect("register");
			}catch (Exception e){
				session.setAttribute("incorrect", "something went wrong");
				resp.sendRedirect("register");
			}

		}
	}
}
