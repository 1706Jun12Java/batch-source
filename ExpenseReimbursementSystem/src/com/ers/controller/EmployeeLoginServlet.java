package com.ers.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.dao.ERS_UsersDao;
import com.ers.dao.ERS_UsersDaoImpl;
import com.ers.domain.ERS_Users;
import com.ers.util.ConnectionUtil;


public class EmployeeLoginServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4421241797628392386L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		try {		
			HttpSession employeeSession = request.getSession(true);
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			ConnectionUtil.getConnectionFromFile("connection.properties");
			ERS_UsersDao e1 = new ERS_UsersDaoImpl();
			System.out.println((e1.getUserByID(username,password)).toString());
			System.out.println(username);
			int uid = e1.getUserID(username, password);
			String firstname = e1.getFirstName(username, password);
			String lastname = e1.getLastName(username,password);
			String email = e1.getEmail(username, password);
			
			if(username != "null"){
				employeeSession.setAttribute("uid", uid);
				employeeSession.setAttribute("username", username);
				employeeSession.setAttribute("password", password);
				employeeSession.setAttribute("firstname", firstname);
				employeeSession.setAttribute("lastname", lastname);
				employeeSession.setAttribute("email", email); 
				response.sendRedirect("employeeHomepage.jsp");
				} else {
				
				response.sendRedirect("404.html");
				}
		} catch (SQLException e) {
			e.printStackTrace(); }
		
	}

}
