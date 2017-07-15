package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2360393340124659683L;

	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		String wasIncorrect = (String) session.getAttribute("incorrect");
		if(wasIncorrect != null){
			pw.print(wasIncorrect);
		}
		req.getRequestDispatcher("login.html").include(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(password.equals("admin")){
			
			session.setAttribute("username", username);
			session.setAttribute("incorrect", null);
			resp.sendRedirect("profile");
		}else{
			session.setAttribute("incorrect", "wrong credentials");
			resp.sendRedirect("login.html");
		}
	}
}
