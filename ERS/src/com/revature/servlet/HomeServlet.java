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

public class HomeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");
        
		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	    
	    try (Connection con = ConnectionUtil.getConnectionFromFile()){	
			PreparedStatement ps = null;
			ResultSet rs = null;
			ps = con.prepareStatement("SELECT U_ID, UR_ID from ERS_USERS where U_USERNAME =?");			
			ps.setString(1, n);				
			rs = ps.executeQuery();
			if(rs.next()){
				int uid = rs.getInt("U_ID");
				int urid = rs.getInt("UR_ID");
				request.setAttribute("uid", uid);
	        	request.setAttribute("urid", urid);
					
				if (urid == 1){ //this should be UR_ID, not U_ID   !!!
					RequestDispatcher rd = request.getRequestDispatcher("WelcomeManager");
			           rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("WelcomeEmployee");
			           rd.forward(request, response);			
				}	        	
			}
			} catch (SQLException e) {
				e.printStackTrace();	        	
		        }
	}
}
