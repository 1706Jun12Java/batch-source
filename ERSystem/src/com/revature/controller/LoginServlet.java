package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.dao.ERUserDao;
import com.revature.dao.ERUserDaoImpl;
import com.revature.domain.User;
import com.revature.exceptions.WrongCredentialsException;
import com.revature.util.RequestHelper;

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
		req.getRequestDispatcher("login.html").forward(req, resp);
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		HttpSession session = req.getSession();
		resp.setContentType("application/json");
		PrintWriter pw = resp.getWriter();
		ERUserDao UD = new ERUserDaoImpl();
		try{
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			System.out.println(username+password);
			User u = UD.loginUser(username, password);
			session.setAttribute("username", u.getUsername());
			session.setAttribute("userID", u.getUserID());
			session.setAttribute("firstname", u.getFirstName());
			session.setAttribute("lastname",u.getLastName());
			session.setAttribute("userType", u.getRoleID());
			String result = "{\"redirect\":\""
					+ RequestHelper.process(u.getRoleID())
					+"\"}";
			pw.write(result);
			
		}catch(WrongCredentialsException e){
			String error = "{\"error\":\"wrong username/password\"}";
			pw.write(error);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
