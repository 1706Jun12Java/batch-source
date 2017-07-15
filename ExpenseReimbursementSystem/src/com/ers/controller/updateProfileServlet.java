package com.ers.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ers.util.ConnectionUtil;

public class updateProfileServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2092903203842920116L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {		
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String username = (String) request.getSession(false).getAttribute("username");

			String sql = "UPDATE ERS_USERS SET U_EMAIL=?,U_PASSWORD=? WHERE U_USERNAME=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			pstmt.setString(3, username);
 			pstmt.executeQuery(); 
			
			response.sendRedirect("employeeLogin.html");
		} catch (SQLException e) {
			e.printStackTrace(); }
		
	}
	
}
