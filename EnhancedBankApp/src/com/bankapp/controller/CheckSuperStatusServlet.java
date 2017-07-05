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

public class CheckSuperStatusServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4505821157800690803L;

	public CheckSuperStatusServlet() {
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
			
			int isAllowed = 0; 
			
			String sql = "SELECT IS_SUPERUSER FROM BANK_USER WHERE USER_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			int newuid = Integer.parseInt(uid);
			pstmt.setInt(1, newuid);
			ResultSet rs = pstmt.executeQuery();
				while(rs.next()){	
				int superUser = rs.getInt("IS_SUPERUSER");
				isAllowed = superUser;
				}
				
				if(isAllowed == 1){
					System.out.println("Congratulations! You are a superuser :)");
					System.out.println("Directing to superuser menu...");
					// response redirect 
					response.sendRedirect("superUserMenu.html");
				}else
				{
					System.out.println("Sorry, you are not a superuser :(");
					 PrintWriter writer = response.getWriter();
			         
				        // build HTML code
				        String htmlRespone = "<html>";
				        htmlRespone += "<h2>Sorry, you are not a superuser! </h2> <br/>";         
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
