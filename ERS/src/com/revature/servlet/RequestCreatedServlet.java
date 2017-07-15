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

import com.revature.util.ConnectionUtil;

public class RequestCreatedServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session=request.getSession(false);  
        String n=(String)session.getAttribute("uname");
        
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
        out.println("<head><meta charset=\"ISO-8859-1\"><title>ERS</title><link href=\"http://fonts.googleapis.com/css?family=Abel|Buenard:400,700\" rel=\"stylesheet\"/><link href=\"ersstyle.css\" rel=\"stylesheet\"></head>");
        out.println("<div id=\"wrapper\">");
        out.println("<body>");        
		out.println("<h1 id=\"header\">Enterprise Reimbursement Management<span>New Request Status</span></h2>");
		
		out.println("<div id=\"nav\">"
				+"<ul>"
					+"<li><a href=\"HomeServlet\" style=\"background-color:#869DC7; padding-top: 10px; padding-bottom: 10px\">Home</a></li>"
					+"<li><a href=\"NewRequestServlet\">New Request</a></li>"
					+"<li><a href=\"login.html\">Manager Login</a></li>"
					+"<li><a href=\"LogoutServlet\" method=\"get\">Log out</a></li>"
					+"</ul>"
				+"</div>");
		out.println("<div class=\"content\">");
		out.println("<div class=\"div4\">");
		out.println("<br>");
		out.println("<p>Thank you "+n+", your request has been submitted</p>"); 
		out.println("<br><br>");
		//response.sendRedirect("index.html");
		out.println("<form action=\"HomeServlet\" method=\"POST\">");
		out.println("<button type=\"submit\" name=\"SubmitButton\" value=\"submit\">See your requests</button>");
		out.println("</form>");
		out.println("</div></div>");
	    out.println("</body></div>");
	    out.println("</html>");		
		}		
}
