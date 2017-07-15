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
import com.ers.util.ConnectionUtil;

public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManagerLoginServlet() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		try {		
			HttpSession managerSession = request.getSession(true);
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			ConnectionUtil.getConnectionFromFile("connection.properties");
			ERS_UsersDao m1 = new ERS_UsersDaoImpl();
			System.out.println((m1.getUserByID(username,password)).toString());
			System.out.println(username);
			int uid = m1.getUserID(username, password);
			String firstname = m1.getFirstName(username, password);
			String lastname = m1.getLastName(username,password);
			String email = m1.getEmail(username, password);
			int ur_id = m1.getUR_ID(username, password);
			
			if(username != "null" && ur_id==1 ){ 
				managerSession.setAttribute("uid", uid);
				managerSession.setAttribute("username", username);
				managerSession.setAttribute("password", password);
				managerSession.setAttribute("firstname", firstname);
				managerSession.setAttribute("lastname", lastname);
				managerSession.setAttribute("email", email); 
				managerSession.setAttribute("ur_id", ur_id); 
				response.sendRedirect("managerHomepage.jsp"); 
				} else {
				
				response.sendRedirect("404.html");
				}
		} catch (SQLException e) {
			e.printStackTrace(); }
		
	}

}
