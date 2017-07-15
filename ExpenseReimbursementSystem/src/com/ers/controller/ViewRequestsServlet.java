package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ers.util.ConnectionUtil;

public class ViewRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewRequestsServlet() {
        super();
        
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {		
			System.out.println("View Requests Servlet - Made it Here");
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
			
			int u_id_author = (int) request.getSession(false).getAttribute("uid");
			
	        PrintWriter out = response.getWriter();
			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE U_ID_AUTHOR=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, u_id_author);
 			ResultSet rs = pstmt.executeQuery();
 			
 			out.println("<br>");
 		    out.println("<center><TABLE class=" + "\"table table-hover>\"" + "style=\"color:white\"");
 		    ResultSetMetaData rm = rs.getMetaData();
 		    int cnum = rm.getColumnCount();
 		    out.println("<TR>");
 		        for(int i=1; i <= cnum; i++) {
 		            out.print("<TH>" + rm.getColumnName(i));
 		        }
 		        out.println();
 		        while(rs.next()) {
 		            out.println("<TR>");
 		                for(int i=1; i <= cnum; i++) {
 		                    out.print("<TD>" + rs.getString(i));
 		                }
 		            out.println();
 		        }
 		        out.println("</TABLE></center>");
			
		} catch (SQLException e) {
			e.printStackTrace(); }
		
	}
}
