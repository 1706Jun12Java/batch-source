package com.bankapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.util.App;


public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6754411160313142431L;

	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(); 
			
			Connection con = App.getConnectionFromFile("connection.properties"); 
			
			String userid = request.getParameter("userid");
			int u_id = Integer.parseInt(userid);
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String superstatus = request.getParameter("superstatus");
			int superuser = Integer.parseInt(superstatus);
			
			String sql = "INSERT INTO BANK_USER (USER_ID,F_NAME,L_NAME,USERNAME,PASSWORD_,IS_SUPERUSER)"
					+ " VALUES(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, u_id);
			pstmt.setString(2, firstname);
			pstmt.setString(3, lastname);
			pstmt.setString(4, username);
			pstmt.setString(5, password);
			pstmt.setInt(6, superuser);
			pstmt.executeUpdate(); 
			
			session.setAttribute("username", username);
			response.sendRedirect("login.html");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("register.html");
		}
	

		
		
      
    }  
}
