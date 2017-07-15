package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Array;
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

public class ApproveServlet extends HttpServlet{

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);  
		String n=(String)session.getAttribute("uname");
	
		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();
	   
	    try (Connection con = ConnectionUtil.getConnectionFromFile()){
	    	
	    	String selectedValue=request.getParameter("select");
	        if(selectedValue.equals("approve")){
				RequestDispatcher rd = request.getRequestDispatcher("ApprovedRequests");
	            rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("DeniedRequests");
				rd.include(request, response);
			}
	    	
		} catch (SQLException e) {
				e.printStackTrace();	        	
	    }
	}
}
