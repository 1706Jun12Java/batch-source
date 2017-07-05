package com.bankapp.controller;

 import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.util.App;

public class ViewAllUsersServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -827764646304219195L;

	public ViewAllUsersServlet() {
	
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		try(Connection con = App.getConnectionFromFile("connection.properties")){
			
			Cookie[] cookies = request.getCookies();
			int i = 0;
			@SuppressWarnings("unused")
			String uid = " ";
			for (@SuppressWarnings("unused") Cookie cookie : cookies ) {

				System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue());
				uid = cookies[0].getValue();
				i++;
			}
			
			String sql = "SELECT * FROM BANK_USER";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()){	
				int u = rs.getInt("USER_ID");
				String fn = rs.getString("F_NAME");
				String ln = rs.getString("L_NAME");
				String un = rs.getString("USERNAME");
				String pw = rs.getString("PASSWORD_"); 
				int ss = rs.getInt("IS_SUPERUSER");
				System.out.println("USER ID: " + u + " FIRST NAME: " + fn + " LAST NAME: " + ln + " USERNAME " + un + " PASSWORD: " + pw + " SUPER STATUS: " + ss );

		        PrintWriter writer = response.getWriter();
		        String htmlRespone = "<html>";
		        htmlRespone += "<h2>USER ID: " + u + "FIRST NAME: " + fn + "LAST NAME: " + ln + "USERNAME: " + un + "PASSWORD: " + pw + "SUPER STATUS: " + ss + "<br/>";         
		        htmlRespone += "</html>";
		        writer.println(htmlRespone);
				}
			
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
