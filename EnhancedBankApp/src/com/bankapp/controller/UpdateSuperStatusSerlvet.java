package com.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankapp.util.App;

public class UpdateSuperStatusSerlvet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2726071573899087530L;

	public UpdateSuperStatusSerlvet() {
		// TODO Auto-generated constructor stub
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
			

			String user = request.getParameter("usertoUpdate");
			int userid = Integer.parseInt(user);
			
			String sql = "UPDATE BANK_USER SET IS_SUPERUSER=? WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, 1);
			pstmt.setInt(2, userid);
 			pstmt.executeQuery(); 
 			
 			System.out.println("Your account has been successfully updated :)");
 			
		        PrintWriter writer = response.getWriter();
		        String htmlRespone = "<html>";
		        htmlRespone += "<h2>Your account has been successfully created." + "<br/>";         
		        htmlRespone += "</html>";
		        writer.println(htmlRespone);
				
			
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
