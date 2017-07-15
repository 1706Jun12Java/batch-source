package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.util.ConnectionUtil;

public class DeniedRequests extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");
        
        try (Connection con = ConnectionUtil.getConnectionFromFile()){

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
	        //String seloption = (String) request.getAttribute("select");
	        //int checked = Integer.parseInt(request.getParameter("checkedRow"));
	        int checked = 62; 
	        PreparedStatement ps = null;
	        ResultSet rs = null;
		 	ps = con.prepareStatement("UPDATE ERS_REIMBURSEMENTS SET RS_STATUS=3, U_ID_RESOLVER=(SELECT U_ID FROM ERS_USERS WHERE U_USERNAME=?) WHERE R_ID=?");
		 	//Array array = con.createArrayOf("NUMBER", checkedIds);
		 	ps.setString(1, n);
		 	ps.setInt(2, checked);		 
		 	rs = ps.executeQuery();
				
		 	if(rs != null){			
		 			out.println("<p>Thank you "+n+", reimbursement request has been denied</p>");
				} else {
					out.println("<p>Request cannot be processed</p>");
				}
		 	//response.sendRedirect("index.html");
			out.println("<form action=\"HomeServlet\" method=\"POST\">");
			out.println("<button type=\"submit\" name=\"SubmitButton\" value=\"submit\">See all requests</button>");
			out.println("</form>");
			
			} catch (SQLException e) {
					e.printStackTrace();	        	
	        }
	}
}
