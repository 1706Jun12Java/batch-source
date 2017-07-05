package com.bankapp.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;  


public class LoginServlet extends HttpServlet {

		/**
	 * 
	 */
	private static final long serialVersionUID = -7709717894635271706L;

		@Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
			
			try {
				
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String userID = TestClass.checkUser(username, password);
				
				
				
				if (userID != "0" || userID !="null") { // .equals(password)
					//pw.println("<p>hello, " + request.getParameter("username") + "</p>");
					
		
					
					 final String cookieName = "userIDCookie";
					 final String cookieValue = userID;  // you could assign it some encoded value
					 final Boolean useSecureCookie = false;
					 final int expiryTime = 60 * 60 * 24;  // 24h in seconds
					 final String cookiePath = "/";
					 
					 
					 Cookie cookie = new Cookie(cookieName, cookieValue);
					 cookie.setSecure(useSecureCookie);  // determines whether the cookie should only be sent using a secure protocol, such as HTTPS or SSL
					 cookie.setMaxAge(expiryTime);  // A negative value means that the cookie is not stored persistently and will be deleted when the Web browser exits. A zero value causes the cookie to be deleted.
					 cookie.setPath(cookiePath);  // The cookie is visible to all the pages in the directory you specify, and all the pages in that directory's subdirectories
					 response.addCookie(cookie);
					 
					 response.sendRedirect("mainMenu.html");
					} else {
					
					response.sendRedirect("index.html");
					}
			} catch (SQLException e) {
				e.printStackTrace(); }
		}
}

