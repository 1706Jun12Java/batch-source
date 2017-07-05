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

public class DeleteAllUsersServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2223323651740915856L;

	public DeleteAllUsersServlet() {
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
			
		String sql = "DELETE FROM BANK_USER";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.executeQuery();
		System.out.println("All users have been deleted from the system.");
		
		        PrintWriter writer = response.getWriter();
		        String htmlRespone = "<html>";
		        htmlRespone += "<h2>All users have been deleted. " + "</h2><br/>";         
		        htmlRespone += "</html>";
		        writer.println(htmlRespone);
				
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
