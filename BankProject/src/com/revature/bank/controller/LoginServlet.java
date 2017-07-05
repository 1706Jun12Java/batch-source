package com.revature.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bank.dao.UserDao;
import com.revature.bank.dao.UserDaoImpl;
import com.revature.bank.domain.User;
import com.revature.bank.exception.WrongCredentialException;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 460042908425479379L;
	public LoginServlet() {
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
		req.getRequestDispatcher("login.html").include(req, resp);
	}
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{

		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		String username = req.getParameter("lg_username");
		String password = req.getParameter("lg_password");
		System.out.println(username+password);
		if(username==""||password==""){
			session.setAttribute("incorrect", "Empty username/password");
			resp.sendRedirect("login");
		}else{
		
		UserDao UD = new UserDaoImpl();
		try{
			User user = UD.getUserByCredential(username, password);
			System.out.println(user);
			session.setAttribute("userID", user.getUserID());
			session.setAttribute("username", username);
			session.setAttribute("userType", user.getUserType());
			session.setAttribute("incorrect", null);

			if(user.getUserType()==1){
				resp.sendRedirect("admin");
			} else {
				resp.sendRedirect("profile");
			}
		} catch(WrongCredentialException e){
			session.setAttribute("incorrect", "wrong username/password");
			req.getRequestDispatcher("login.html").include(req, resp);
		} catch(Exception e){
			resp.sendRedirect("404.html");
		}
	}}
}
