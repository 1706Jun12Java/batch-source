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



public class ViewBalanceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4224992146844527175L;

	public ViewBalanceServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		try(Connection con = App.getConnectionFromFile("connection.properties")){
			
			Cookie[] cookies = request.getCookies();
			int i = 0;
			String uid = " ";
			for (@SuppressWarnings("unused") Cookie cookie : cookies ) {

				System.out.println(cookies[i].getName());
				System.out.println(cookies[i].getValue());
				uid = cookies[0].getValue();
				i++;
			}
			
			String sql = "SELECT BALANCE FROM BANK_ACCOUNT WHERE ACCOUNT_USER_ID =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			int newuid = Integer.parseInt(uid);
			pstmt.setInt(1, newuid);
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()){	;
				double balance = rs.getFloat("BALANCE");
				System.out.println("Your balance is: $" + balance);
				
				
				// Process HTML response here: 
				// get response writer
		        PrintWriter writer = response.getWriter();
		         
		        // build HTML code
		        String htmlRespone = "<html>";
		        htmlRespone += "<h2>Your balance is: " + balance + "<br/>";         
		        htmlRespone += "</html>";
		         
		        // return response
		        writer.println(htmlRespone);
				}
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		
	}

}
