package com.revature.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.bank.dao.SuperUserDao;
import com.revature.bank.dao.SuperUserDaoImpl;
import com.revature.bank.domain.User;
import com.revature.bank.exception.UniqueIDException;

public class SuperUserServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4813708206356989376L;


	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		resp.setContentType("text/html");
		HttpSession session = req.getSession(false);
		if(session==null){
			resp.sendRedirect("login.html");
		}
		System.out.println(session);
		int type = 0;
		try{
			type = (Integer) session.getAttribute("userType");
			if(type!=1){
				resp.sendRedirect("login.html");
			}
		}catch(Exception e){
			e.printStackTrace();
			resp.sendRedirect("404.html");
		}
		
		SuperUserDao SUD = new SuperUserDaoImpl();
		String wasIncorrect = (String) session.getAttribute("incorrect");
		req.setAttribute("error", wasIncorrect);
		try{
			List<User> userList = SUD.getUsers();
			req.setAttribute("userList", userList);
			req.getRequestDispatcher("admin.jsp").include(req, resp);
		}catch(Exception e){
			e.printStackTrace();
			resp.sendRedirect("404.html");
		}
	}
	
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		int type = 0;
		try{
			type = (Integer) session.getAttribute("userType");
			if(type!=1){
				resp.sendRedirect("login.html");
			}
		}catch(Exception e){
			e.printStackTrace();
			resp.sendRedirect("404.html");
		}
		String submit = req.getParameter("submit");
		SuperUserDao SUD = new SuperUserDaoImpl();
		switch(submit){
		case "create":
			try{
				int userID = Integer.parseInt(req.getParameter("userID"));
				String username = (String) req.getParameter("username");
				String password = (String) req.getParameter("password");
				int userType = Integer.parseInt(req.getParameter("type"));
				System.out.println(userID+username+password+userType);
				User newUser = new User(username,password,userType);
				int res = SUD.createUser(newUser);
				System.out.println(res);
				if(res==1){
					session.setAttribute("incorrect", null);
					resp.sendRedirect("admin");
					break;
				}else{
					session.setAttribute("incorrect", "user exist");
					resp.sendRedirect("admin");
				}
				break;
			}catch(UniqueIDException e){
				session.setAttribute("incorrect", "user exist");
				resp.sendRedirect("admin");
			}
			catch(Exception e){
				req.getRequestDispatcher("404.html").include(req,resp);
			}
			break;
		case "update":
			try{
				int userID = Integer.parseInt(req.getParameter("userID"));
				String username = (String) req.getParameter("username");
				String password = (String) req.getParameter("password");
				int userType = Integer.parseInt(req.getParameter("type"));
				User newUser = new User(userID,username,password,userType);
				int res = SUD.updateUser(newUser);
				System.out.println(res);
				if(res==1){
					session.setAttribute("incorrect", null);
					resp.sendRedirect("admin");
				}else{
					session.setAttribute("incorrect", "user exist");
					resp.sendRedirect("admin");
				}
			}catch(Exception e){
				req.getRequestDispatcher("404.html").include(req,resp);
			}
			break;
		case "delete":
			try{
				int userID = Integer.parseInt(req.getParameter("userID"));
				int res = SUD.deleteUser(userID);
				System.out.println(res);
				if(res==1){
					session.setAttribute("incorrect", null);
					resp.sendRedirect("admin");
				}else{
					session.setAttribute("incorrect", "user does not exist");
					resp.sendRedirect("admin");
				}
			}catch(Exception e){
				req.getRequestDispatcher("404.html").include(req,resp);
			}
			break;
		}
	}
}
