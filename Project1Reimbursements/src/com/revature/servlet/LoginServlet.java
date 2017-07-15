package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class LoginServlet extends HttpServlet{

	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		/*
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		String wasIncorrect = (String) session.getAttribute("incorrect");
		if (wasIncorrect != null){
			pw.println(wasIncorrect);
			
		}
		req.getRequestDispatcher("/loginpage").include(req, resp);
		*/
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		HttpSession session = req.getSession();
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		UserDaoImpl userDao = new UserDaoImpl();
		User user=userDao.userLogin(username, password);
		if(user==null){
			session.setAttribute("incorrect", "Inccorect information, try again");
			res.sendRedirect("loginPage");
		}
		else {
			System.out.println("YOU LOGGED IN");
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			res.sendRedirect("employeeProfile");
		}
	}
}
