package com.ers.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.util.ConnectionUtil;


public class reimbReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public reimbReqServlet() {
        super();
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		try {		
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String ra = request.getParameter("rAmount");
			double rAmount = Double.parseDouble(ra);
			String rDescription = request.getParameter("rDescription");
			String rReceipt = request.getParameter("rReceipt");
			String rt = request.getParameter("rtType");
			int rtType =  Integer.parseInt(rt); 
			String username = (String) request.getSession(false).getAttribute("username");
			int uid = (int) request.getSession(false).getAttribute("uid");

			String sql= " INSERT INTO ERS_REIMBURSEMENTS"
					+ "(R_ID,R_AMOUNT,R_DESCRIPTION,U_ID_AUTHOR,U_ID_RESOLVER,RT_TYPE,RT_STATUS,R_RECEIPT)"
					+ "VALUES (R_SEQUENCE.nextval,?,?,?,1,?,1,?)"; 
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, rAmount);
			pstmt.setString(2, rDescription);
			pstmt.setInt(3, uid);
			pstmt.setInt(4, rtType);
			pstmt.setString(5, rReceipt);
 			pstmt.executeQuery(); 
			
			response.sendRedirect("successfulSubmission.jsp");
		} catch (SQLException e) {
			e.printStackTrace(); }
		
	}

}
