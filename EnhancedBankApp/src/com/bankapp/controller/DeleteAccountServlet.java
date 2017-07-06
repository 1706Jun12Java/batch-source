package com.bankapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
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
			
			String un = (String) request.getSession(false).getAttribute("username");
			
			System.out.println(un);
			String sql = "SELECT BANK_ACCOUNT.BALANCE, ACCOUNT_USER_ID FROM BANK_ACCOUNT  INNER JOIN BANK_USER ON BANK_ACCOUNT.ACCOUNT_USER_ID = BANK_USER.USER_ID WHERE BANK_USER.USERNAME =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, un);
			ResultSet rs = pstmt.executeQuery();
					while(rs.next()){	;
					double balance = rs.getFloat("BALANCE");
					int accountUserID = rs.getInt("ACCOUNT_USER_ID");
					System.out.println("Your balance is: $" + balance);
					
					if(balance < 1){
						
						String sqlstmt = "DELETE FROM BANK_ACCOUNT WHERE ACCOUNT_USER_ID =?";
						PreparedStatement ps =con.prepareStatement(sqlstmt);
						pstmt.setInt(1, accountUserID);
						@SuppressWarnings("unused")
						ResultSet r = ps.executeQuery();
						System.out.println("Deletion complete");
						
						PrintWriter writer = response.getWriter();
						String h = "<!doctype html>";
								h+="<html>";
								h+="<head>";
								h+="<title>Delete Empty Account</title>"; 
		
								h+="<meta charset=\"utf-8\" />";
								h+= "<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />";
								h+="<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />";
								h+="<link rel=\"stylesheet\"";
								h+="href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"";
								h+="integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"";
								h+="crossorigin=\"anonymous\">";
								h+="<style type=\"text/css\">";
								h+="body {";
								h+= "background-color:   #d1f2eb; margin: 0; padding: 0;";
								h+="font-family: \"Open Sans\", \"Helvetica Neue\", Helvetica, Arial, sans-serif;";
								h+="}";
								h+="div {";
								h+=" width: 600px; margin: 5em auto; padding: 50px; background-color: #fff; border-radius: 1em;";
								h+="}";
								h+= "a:link, a:visited {";
								h+= "color: #38488f;";
								h+= "text-decoration: none;";
								h+="}";
								h+="@media (max-width: 700px) {";
								h+="body {";
								h+="background-color: #fff;";
								h+="}";
								h+="div {";
								h+="width: auto;";
								h+="margin: 0 auto;";
								h+="border-radius: 0;";
								h+="padding: 1em;";
								h+="}";
								h+="}";
								h+="</style>";   
								h+="</head>";
								h+="<body>";
								h+="<div>";
								h+="<h1><center>Since your account was empty, it has been deleted!</center></h1>";
								h+="</br>";
								h+="</div>";
								h+="</body>";
								h+="</html>";
								writer.println(h);
						
					}
					else {
						
						PrintWriter writer = response.getWriter();
						String h = "<!doctype html>";
								h+="<html>";
								h+="<head>";
								h+="<title>Account Balance </title>"; 
		
								h+="<meta charset=\"utf-8\" />";
								h+= "<meta http-equiv=\"Content-type\" content=\"text/html; charset=utf-8\" />";
								h+="<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />";
								h+="<link rel=\"stylesheet\"";
								h+="href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\"";
								h+="integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\"";
								h+="crossorigin=\"anonymous\">";
								h+="<style type=\"text/css\">";
								h+="body {";
								h+= "background-color:   #d1f2eb; margin: 0; padding: 0;";
								h+="font-family: \"Open Sans\", \"Helvetica Neue\", Helvetica, Arial, sans-serif;";
								h+="}";
								h+="div {";
								h+=" width: 600px; margin: 5em auto; padding: 50px; background-color: #fff; border-radius: 1em;";
								h+="}";
								h+= "a:link, a:visited {";
								h+= "color: #38488f;";
								h+= "text-decoration: none;";
								h+="}";
								h+="@media (max-width: 700px) {";
								h+="body {";
								h+="background-color: #fff;";
								h+="}";
								h+="div {";
								h+="width: auto;";
								h+="margin: 0 auto;";
								h+="border-radius: 0;";
								h+="padding: 1em;";
								h+="}";
								h+="}";
								h+="</style>";   
								h+="</head>";
								h+="<body>";
								h+="<div>";
								h+="<h1><center>Since your account was not empty, it has NOT been deleted!</center></h1>";
								h+="</br>";
								h+="</div>";
								h+="</body>";
								h+="</html>";
			        writer.println(h);
						
						
						
					}
					
				
					
		        
				}
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		
	}
	
	
			
}
