package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Util.ConnectionUtil;

public class LogOut extends HttpServlet{

	public LogOut() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession sess= request.getSession();
		sess.invalidate();
		ConnectionUtil.closeConnection();
		response.sendRedirect("LogIn.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}
