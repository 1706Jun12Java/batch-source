package com.bankapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankapp.dao.Bank_UserDao;
import com.bankapp.dao.Bank_UserDaoImpl;
import com.bankapp.util.App;  


public class LoginServlet extends HttpServlet {

		/**
	 * 
	 */
	
	private static final long serialVersionUID = -7709717894635271706L;

		@Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
			
			try {
				
				
				HttpSession sessionOldUser = request.getSession(true);
				// ***** 
				//String un = (String) sessionOldUser.getAttribute("username");
				
				
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				App.getConnectionFromFile("connection.properties");
				Bank_UserDao u1 = new Bank_UserDaoImpl();
				System.out.println((u1.getBank_UserByID(username,password)).toString());
				System.out.println(username);
				
				
				if(username != "null"){
					sessionOldUser.setAttribute("username", username);
					System.out.println(username);
					response.sendRedirect("mainMenu.html");
					} else {
					
					response.sendRedirect("index.html");
					}
			} catch (SQLException e) {
				e.printStackTrace(); }
		}
}

