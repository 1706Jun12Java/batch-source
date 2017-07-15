package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.ConnectionUtil;

public class LoginServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	   
	    try (Connection con = ConnectionUtil.getConnectionFromFile()){
		String uname = request.getParameter("PersonUName");
		String upassword = request.getParameter("PersonPass");
		String passworddb = null;
		
		HttpSession session=request.getSession();  
        session.setAttribute("uname",uname);  
		
		//userDao ud = new userDao();
		//ResultSet rs = ud.login(uname, upassword);
		
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 ps = con.prepareStatement("SELECT * from ERS_USERS where U_USERNAME =?");			
		 ps.setString(1, uname);		 
		 rs = ps.executeQuery();
		
		if(rs != null && rs.next()){
			passworddb = rs.getString("U_PASSWORD");			
			}

	        if(upassword.equals(passworddb)){
	        	int uid = rs.getInt("U_ID");
	        	request.setAttribute("uid", uid);
	        	String username = rs.getString("U_USERNAME");
	        	request.setAttribute("username", username);
	        	String fname = rs.getString("U_FIRSTNAME");
	        	request.setAttribute("firstname", fname);
	        	String lname = rs.getString("U_LASTNAME");
	        	request.setAttribute("lastname", lname);
	        	int urid = rs.getInt("UR_ID");
				request.setAttribute("urid", urid);
				
				if (urid == 1){
					RequestDispatcher rd = request.getRequestDispatcher("WelcomeManager");
		            rd.forward(request, response);
				} else{
					RequestDispatcher rd = request.getRequestDispatcher("WelcomeEmployee");
		            rd.forward(request, response);			
				}	        	
				 
	        } else {
	        	out.println("<font color='red'><b>You have entered incorrect password</b></font>");
	            RequestDispatcher rd = request.getRequestDispatcher("login.html");
	            rd.include(request, response);
	        } 
		} catch (SQLException e) {
			e.printStackTrace();	        	
	        }
	}
}
	

