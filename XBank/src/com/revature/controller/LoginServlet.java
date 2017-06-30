package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 549154456290863668L;
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
			pw.println(wasIncorrect);
		}
		req.getRequestDispatcher("login.html").include(req, resp);
	}
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{

		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("lg_username");
		String password = req.getParameter("lg_password");
		
		UserDao UD = new UserDaoImpl();
		try{
			User user = UD.getUserByCredential(username, password);
			session.setAttribute("userID", user.getUserID());
			session.setAttribute("username", username);
			session.setAttribute("userType", user.getUserType());

			if(user.getUserType()==1){
				resp.sendRedirect("admin.html");
			} else {
				resp.sendRedirect("main.html");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
