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



public class ViewBalanceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4224992146844527175L;

	public ViewBalanceServlet() {
		// TODO Auto-generated constructor stub
	}
	
	/*@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
	
	}*/
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		
		try(Connection con = App.getConnectionFromFile("connection.properties")){
			
			String un = (String) request.getSession(false).getAttribute("username");
			
			/*SELECT BANK_ACCOUNT.BALANCE 
			FROM BANK_ACCOUNT 
			INNER JOIN BANK_USER
			ON BANK_ACCOUNT.ACCOUNT_USER_ID = BANK_USER.USER_ID
			WHERE BANK_USER.USERNAME = 'mzaman';*/
			
			System.out.println(un);
			String sql = "SELECT BANK_ACCOUNT.BALANCE FROM BANK_ACCOUNT  INNER JOIN BANK_USER ON BANK_ACCOUNT.ACCOUNT_USER_ID = BANK_USER.USER_ID WHERE BANK_USER.USERNAME =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, un);
			ResultSet rs = pstmt.executeQuery();
					while(rs.next()){	;
					double balance = rs.getFloat("BALANCE");
					System.out.println("Your balance is: $" + balance);
					
				
					PrintWriter writer = response.getWriter();
			        /*String htmlRespone = "<html>";
			        htmlRespone += "<h2>Your balance is: " + balance + "<h2/>";         
			        htmlRespone += "</html>";*/
					
	
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
							h+="<h1><center>Account Balance</center></h1>";
							h+="<h2><center> $"+balance+" <center></h2>";
							h+="</br>";
							h+="</div>";
							h+="</body>";
							h+="</html>";
		        writer.println(h);
		        
				}
		}catch (SQLException e){
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}


		
	}

}
