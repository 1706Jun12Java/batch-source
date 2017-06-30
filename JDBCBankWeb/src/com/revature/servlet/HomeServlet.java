package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.BankUserDao;
import com.revature.dao.BankUserDaoImpl;

public class HomeServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
//		String wasIncorrect = (String) session.getAttribute("incorrect");
//		if (wasIncorrect != null){
//			pw.println(wasIncorrect);
//		}
		req.getRequestDispatcher("home.html").include(req, resp);
		
	}
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		BankUserDao blid = new BankUserDaoImpl(); //bank user object		
		
		
		
		if (blid.login(username, password) !=0){
			pw.print("SUCCESS");
			int userId = blid.login(username, password);
			session.setAttribute("userId", userId);
			session.setAttribute("username", username);
			session.setAttribute("incorrect",null);
			resp.sendRedirect("accounts");
			
		} else {
			session.setAttribute("incorrect", "incorrect password");
			resp.sendRedirect("home");
		}
		
	}

}
