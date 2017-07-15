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

public class ManagerViewEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerViewEmployeesServlet() {
        super();
    }
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {	
			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
	        PrintWriter out = response.getWriter();
			String sql = "SELECT ERS_USERS.U_ID AS ID, ERS_USERS.U_FIRSTNAME || ' ' || ERS_USERS.U_LASTNAME AS NAME, ERS_USERS.U_USERNAME AS USERNAME, ERS_USERS.U_EMAIL AS EMAIL FROM ERS_USERS";
			PreparedStatement pstmt = con.prepareStatement(sql);
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
