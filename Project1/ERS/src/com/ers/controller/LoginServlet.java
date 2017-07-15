package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.dao.UserDao;
import com.ers.dao.UserDaoLogic;
import com.ers.dao.UserRoleDao;
import com.ers.dao.UserRoleDaoLogic;

public class LoginServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
///		if (session!=null){			
			if ((session.getAttribute("managerId"))!=null){
				resp.sendRedirect("manager-profile");
			} else if ((session.getAttribute("employeeId"))!=null){
				resp.sendRedirect("employee-profile");
			}
//	}
		 else{
			req.getRequestDispatcher("views/html/login.html").include(req, resp);
		}		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserDao user = new UserDaoLogic();
		
		PrintWriter pw = resp.getWriter();
		
		int userId = user.login(username, password);
		//get user's role id to check if user is a manager or an employee
		int userRoleId = user.getUser(userId).getRoleId();
		
//		
//		
		UserRoleDao userRole = new UserRoleDaoLogic();
		int managerRoleId = userRole.getIdOfRole("Manager");
		int employeeRoleId = userRole.getIdOfRole("Employee");
		
		
		if (userId!=0){
			if (userRoleId==managerRoleId){
				session.setAttribute("managerId", userId);
				session.setAttribute("managerUserName", user.getUser(userId).getUserName());
				session.setAttribute("managerFirstName", user.getUser(userId).getFirstName());
				session.setAttribute("managerLastName", user.getUser(userId).getLastName());
				session.setAttribute("managerEmail", user.getUser(userId).getEmail());
				resp.sendRedirect("manager-profile");
			}
			else if (userRoleId==employeeRoleId){
				session.setAttribute("employeeId", userId);
				session.setAttribute("employeeUserName", user.getUser(userId).getUserName());
				session.setAttribute("employeeFirstName", user.getUser(userId).getFirstName());
				session.setAttribute("employeeLastName", user.getUser(userId).getLastName());
				session.setAttribute("employeeEmail", user.getUser(userId).getEmail());
				resp.sendRedirect("employee-profile");
				
			}
		}
				
//				&& userRoleId==managerRoleId){
//			session.setAttribute("managerId", userId);
//			session.setAttribute("managerUserName", user.getUser(userId).getUserName());
//			session.setAttribute("managerFirstName", user.getUser(userId).getFirstName());
//			session.setAttribute("managerLastName", user.getUser(userId).getLastName());
//			session.setAttribute("managerEmail", user.getUser(userId).getEmail());
//			resp.sendRedirect("manager-profile");
//		}
//		else if (userId!=0 && userRoleId==employeeRoleId){
//			session.setAttribute("employeeId", userId);
//			session.setAttribute("employeeUserName", user.getUser(userId).getUserName());
//			session.setAttribute("employeeFirstName", user.getUser(userId).getFirstName());
//			session.setAttribute("employeeLastName", user.getUser(userId).getLastName());
//			session.setAttribute("employeeEmail", user.getUser(userId).getEmail());
//			resp.sendRedirect("employee-profile");
		
		else {
			String errorMessage = "Invalid username/password";
			resp.getWriter().write(errorMessage);
		}		
	}
	
	

}

//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//	}
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//	}
