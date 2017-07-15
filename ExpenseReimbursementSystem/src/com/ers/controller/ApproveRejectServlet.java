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

public class ApproveRejectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ApproveRejectServlet() {
        super();
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {		
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			String rid = request.getParameter("r_id");
			int r_id = Integer.parseInt(rid);
			String updateTo = request.getParameter("updateTo");
			int new_rt_status = Integer.parseInt(updateTo);

			String sql = "UPDATE ERS_REIMBURSEMENTS SET RT_STATUS=? WHERE R_ID=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1,new_rt_status );
			pstmt.setInt(2, r_id);
 			pstmt.executeQuery(); 
			
			response.sendRedirect("managerSuccessfulSubmission.jsp");
		} catch (SQLException e) {
			e.printStackTrace(); }
		
	}

}
