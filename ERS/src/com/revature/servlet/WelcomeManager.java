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

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.userDao;
import com.revature.util.ConnectionUtil;

public class WelcomeManager extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String fname = (String) request.getAttribute("firstname");
		String lname = (String) request.getAttribute("lastname");
		
		HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");  
		
        out.println("<html>");
        //out.println("<head><link rel=\"stylesheet\" href=\"style.css\"><title>All Employees</title></head>");
        out.println("<body>");
        
		out.println("<h2>Welcome "+fname+" "+lname+"</h2>");
		out.println("<p>Please review all pending requests: </p>"); 
		
		//out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=80%>"//out.println("<table BORDER=1 style=\"font-family:arial,sans-serif;border-collapse:collapse;width:80%\">"
		out.println("<form action=\"ApproveServlet\" method=\"POST\">");
		out.println("<table width=80%>"
	              +"<tr>"
	              +"<th>ID</th><th>Status</th><th>Amount</th><th>Description</th><th>Submitted</th>"
	              +"<th>Author</th><th>Type</th><th>Resolved</th><th>Resolver</th><th>Select</th>"
	              +"</tr>");
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			
			ps = con.prepareStatement("SELECT R.R_ID,R.R_AMOUNT,R.R_DESCRIPTION,R.R_SUBMITTED,R.R_RESOLVED,U.U_FIRSTNAME||' '||U.U_LASTNAME AS AUTHOR,U2.U_FIRSTNAME||' '||U2.U_LASTNAME AS RESOLVER,RS.RS_STATUS AS STATUS, RT.RT_TYPE AS TYPE FROM ERS_REIMBURSEMENTS R LEFT JOIN ERS_USERS U ON R.U_ID_AUTHOR = U.U_ID LEFT JOIN ERS_USERS U2 ON R.U_ID_RESOLVER = U2.U_ID LEFT JOIN ERS_REIMBURSEMENT_STATUS RS ON R.RS_STATUS = RS.RS_ID LEFT JOIN ERS_REIMBURSEMENT_TYPE RT ON R.RT_TYPE = RT.RT_ID");		
			rs = ps.executeQuery();
		
			while(rs.next()){
				//int rid = rs.getInt("R_ID");
				out.println("<tr>"
						+ "<td><center>"+rs.getInt("R_ID")+"</center></td>"
						+ "<td><center>"+rs.getString("STATUS")+"</center></td>"
				        + "<td><center>"+rs.getInt("R_AMOUNT")+"</center></td>"				               
				        + "<td><center>"+rs.getString("R_DESCRIPTION")+"</center></td>"
				        + "<td><center>"+rs.getTimestamp("R_SUBMITTED")+"</center></td>"
				        + "<td><center>"+rs.getString("AUTHOR")+"</center></td>"
				        + "<td><center>"+rs.getString("TYPE")+"</center></td>"
				        + "<td><center>"+rs.getTimestamp("R_RESOLVED")+"</center></td>"
				        + "<td><center>"+rs.getString("RESOLVER")+"</center></td>"
				        //+ "<td><input type=\"checkbox\" name=\"checkedRow\" value=\""+rid+"/></td>"
				        + "<td><input type=\"checkbox\" name=\"checkedRow\" value=rs.getInt(\"R_ID\")/></td>"				        
				        +"</tr>");
			}		
		
		out.println("</table><p></p>");
		out.println("<select style=\"position:relative;left:75%;\" name=\"select\"><option value=\"approve\" selected>Approve</option><option value=\"deny\">Deny</option></select><br><br>");
		out.println("<button style=\"position:relative;left:75%;\" type=\"submit\" name=\"SubmitButton\" value=\"submit\">Submit</button>");		
		out.println("</form>");
		
		//response.sendRedirect("index.html");
		out.println("<a style=\"color:black\" href=\"manager.html\">Go home</a>");		
	    out.println("</body>");
	    out.println("</html>");
	    out.close();
	    
		} catch (SQLException e) {
				e.printStackTrace();	        	
	    }
	}
}


