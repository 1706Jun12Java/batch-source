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

public class DepositMoneyServlet extends HttpServlet{
	
	private static final long serialVersionUID = -329127766482802760L;

	public DepositMoneyServlet() {
	}
	
	@SuppressWarnings("unused")
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
	try(Connection con = App.getConnectionFromFile("connection.properties")){
			
			String depositAmount  = request.getParameter("depositAmount");
			
			Cookie[] cookies = request.getCookies();
			int i = 0;
			String uid = " ";
			for (Cookie cookie : cookies ) {

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
				depositAmount = balance + depositAmount;
				}
			
			String sq = "UPDATE BANK_ACCOUNT SET BALANCE=? WHERE ACCOUNT_USER_ID=?"; 
			PreparedStatement pstm = con.prepareStatement(sq);
			int depAmount = Integer.parseInt(depositAmount);
			pstm.setDouble(1, depAmount);
			int nuid = Integer.parseInt(uid);
			pstmt.setInt(2, nuid);
			ResultSet r = pstm.executeQuery();
			System.out.println("Your balance has been adjusted.");
			
			 PrintWriter writer = response.getWriter();
		     String htmlRespone = "<html>";
		     htmlRespone += "<h2>Your balance has been adjusted</h2><br/>";         
		     htmlRespone += "</html>"; 
		     writer.println(htmlRespone);
			
			
	} catch (SQLException e){
		e.printStackTrace();
	} catch (IOException e1) {
		e1.printStackTrace();
	}
		
	}

}
