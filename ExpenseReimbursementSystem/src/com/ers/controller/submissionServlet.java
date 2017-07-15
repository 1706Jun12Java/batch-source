package com.ers.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.util.ConnectionUtil;

public class submissionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			String image = request.getParameter("input-file-preview"); // GET FILE PARAMETER 
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			              
			PreparedStatement ps=con.prepareStatement("INSERT INTO ERS_REIMBURSEMENT_RECEIPTS VALUES(RECEIPT_SEQUENCE.NEXTVAL,?)");  
			ps.setString(1,image);
			ps.executeQuery();  
			response.sendRedirect("successfulSubmission.jsp");
		} catch (Exception e) {
			e.printStackTrace(); }
		
	
	}

}
