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

public class DeleteAccountServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8924038867580212852L;

	public DeleteAccountServlet() {
		
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
				while(rs.next()){	
				double balance = rs.getFloat("BALANCE");
				System.out.println("Your balance is: $" + balance);
				if(balance < 1){
					System.out.println("Since you're balance is empty, your account is being deleted...");
					String sqlstmt = "DELETE FROM BANK_ACCOUNT WHERE ACCOUNT_USER_ID =?";
					PreparedStatement ps =con.prepareStatement(sqlstmt);
					pstmt.setInt(1, newuid);
					@SuppressWarnings("unused")
					ResultSet r = ps.executeQuery();
					System.out.println("Deletion complete");
					// Process HTML response here: 
					// get response writer
			        PrintWriter writer = response.getWriter();
			         
			        // build HTML code
			        String htmlRespone = "<html>";
			        htmlRespone += "<h2> Deletion complete "+ "<br/>";         
			        htmlRespone += "</html>";
			         
			        // return response
			        writer.println(htmlRespone);
					
				} else {
					PrintWriter writer = response.getWriter();
			        String htmlRespone = "<html>";
			        htmlRespone += "<h2> Your balance is >0, your account can not be deleted."+ "<br/>";         
			        htmlRespone += "</html>";
			        writer.println(htmlRespone);
				}
				
				}
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
