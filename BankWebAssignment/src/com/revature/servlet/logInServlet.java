package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.User;
import com.revature.main.ActionCaller;

public class logInServlet extends HttpServlet {

	public logInServlet() {
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		doPost(req,resp);
		

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
		PrintWriter pw = resp.getWriter();
		User user = ActionCaller.signIn(req.getParameter("username"), req.getParameter("password"), req, resp);
		if(user != null){
			HttpSession sess = req.getSession();
			sess.setAttribute("user", user);
			resp.sendRedirect("signIn");
		} 
		
		
	}
}
