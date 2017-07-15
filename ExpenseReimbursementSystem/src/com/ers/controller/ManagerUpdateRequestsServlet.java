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



public class ManagerUpdateRequestsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ManagerUpdateRequestsServlet() {
        super();
    }

    @Override
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      	try {	
  			Connection con = ConnectionUtil.getConnectionFromFile("connection.properties");
  	        PrintWriter out = response.getWriter();
  			String sql = "SELECT * FROM ERS_REIMBURSEMENTS WHERE RT_STATUS=1";
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
   		        
   		        out.println("<br>");
   		        out.println("</br></br>");
   		        out.println("<div class=\"container\" style=\"color:white; font-family:'Lato',sans-serif;\">"); 
   		        out.println("<form method=\"post\" action=\"ApproveRejectServlet\">");
   		        // The ApproveRejectServlet will change the status and then will redirect to manager homepage. 
   		        out.println("<div class=\"form-group row\">");
   		        out.println("<label for=\"r_id\" class=\"col-sm-2 col-form-label\">R_ID</label>");
   		        out.println("<div class=\"col-sm-10\">");
   		        out.println(" <input type=\"text\" name=\"r_id\" class=\"form-control\" id=\"r_id\" placeholder=\"Enter the R_ID of the reimbursement you would like to update...\">");
   		        out.println("</div>");
   		        out.println("</div>");
   		        
   		        out.println("<div class=\"form-group row\">");
   		        out.println("<label for=\"updateTo\" class=\"col-sm-2 col-form-label\">Update To</label>");
   		        out.println("<div class=\"col-sm-10\">");
   		        out.println("<p>Options:");
   		        out.println("<p>		Enter \"1\" for Needs further verification.</p>");
   		        out.println("<p>		Enter \"2\" for Approved.</p>");
   		        out.println("<p>		Enter \"3\" for Rejected.</p>"); 
   		        out.println("</p>");
   		        out.println("<input type=\"text\" name=\"updateTo\" class=\"form-control\" id=\"updateTo\" placeholder=\"Enter a number option...\">");
   		        out.println("</div>");
		        out.println("</div>");
        
   		        out.println("<div class=\"form-group row\">");
   		        out.println("<div class=\"offset-sm-2 col-sm-10\">");
   		        out.println("<button type=\"submit\" class=\"btn btn-primary\">Update</button>");
   		        out.println("</div>");
		        out.println("</div>");
		        out.println("</form>");
   		        out.println("</div>");
   		        
  		} catch (SQLException e) {
  			e.printStackTrace(); }
  		
  	
  	}


}
