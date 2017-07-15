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

public class WelcomeEmployee extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
			String fname = (String) request.getAttribute("firstname");
			String lname = (String) request.getAttribute("lastname");
			int userid = (int) request.getAttribute("uid");
		
		HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");  
		
        out.println("<html>");
        out.println("<head><meta charset=\"ISO-8859-1\"><title>ERS</title><link href=\"http://fonts.googleapis.com/css?family=Abel|Buenard:400,700\" rel=\"stylesheet\"/><link href=\"ersstyle.css\" rel=\"stylesheet\"></head>");
        out.println("<div id=\"wrapper\">");
        out.println("<body>");        
		out.println("<h1 id=\"header\">Welcome "+fname+" "+lname+"<span>Your username is: "+n+"</span></h2>");
		
		out.println("<div id=\"nav\">"
				+"<ul>"
					+"<li><a href=\"index.html\" style=\"background-color:#869DC7; padding-top: 10px; padding-bottom: 10px\">Home</a></li>"
					+"<li><a href=\"NewRequestServlet\">New Request</a></li>"
					+"<li><a href=\"login.html\">Manager Login</a></li>"
					+"<li><a href=\"LogoutServlet\" method=\"get\">Log out</a></li>"
					+"</ul>"
				+"</div>");
		out.println("<div class=\"content\">");
		out.println("<div class=\"div3\">");
		out.println("<p>Requests submitted by you:</p>"); 
		out.println("<form action=\"HelloServlet\" method=\"POST\">");
		out.println("<table width=80%>"
	              +"<tr>"
	              +"<th>ID</th><th>Status</th><th>Amount</th><th>Descr</th><th>Submitted</th>"
	              +"<th>Author</th><th>Type</th><th>Resolved</th><th>Resolver</th>"
	              +"</tr>");
		
		//ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		//ResultSet rs = rdi.allRequests();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			
			ps = con.prepareStatement("SELECT R.R_ID,R.R_AMOUNT,R.R_DESCRIPTION,R.R_SUBMITTED,R.R_RESOLVED,U.U_FIRSTNAME||' '||U.U_LASTNAME AS AUTHOR,U2.U_FIRSTNAME||' '||U2.U_LASTNAME AS RESOLVER,RS.RS_STATUS AS STATUS, RT.RT_TYPE AS TYPE FROM ERS_REIMBURSEMENTS R LEFT JOIN ERS_USERS U ON R.U_ID_AUTHOR = U.U_ID LEFT JOIN ERS_USERS U2 ON R.U_ID_RESOLVER = U2.U_ID LEFT JOIN ERS_REIMBURSEMENT_STATUS RS ON R.RS_STATUS = RS.RS_ID LEFT JOIN ERS_REIMBURSEMENT_TYPE RT ON R.RT_TYPE = RT.RT_ID WHERE U.U_ID=?");		
			ps.setInt(1, userid);
			rs = ps.executeQuery();
		
			while(rs.next()){
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
				        +"</tr>");
			}		
		
		out.println("</table><p></p>");
		out.println("</form>");
		
		//response.sendRedirect("index.html");
		out.println("<a style=\"color:black\" href=\"newrequest.html\">Submit a new request</a>");
		out.println("</div></div>");
	    out.println("</body></div>");
	    out.println("</html>");
	    out.close();
	    
		} catch (SQLException e) {
			e.printStackTrace();	        	
	        }
	}

}
