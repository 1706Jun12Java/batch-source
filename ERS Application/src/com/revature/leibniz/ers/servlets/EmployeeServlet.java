package com.revature.leibniz.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.leibniz.ers.dao.ReimbursementRequestImpDao;
import com.revature.leibniz.ers.domain.Employee;
import com.revature.leibniz.ers.domain.ReimbursementRequest;

public class EmployeeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {	
		myService(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {	
		myService(req, resp);
	}
	
	private void myService(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException  {
		HttpSession session = req.getSession();
		Employee emp = (Employee) session.getAttribute("employee"); 
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset = 'ISO-8859-1'>");
		pw.println("<link rel='stylesheet' href='./css/mystyle.css'>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1 class ='title'> Welcome "+emp.getFirstname()+"</h1>");
		
		pw.println("<a href='makeRR'><div class='xcontainer'>");
		pw.println("<h3>Make Reimbursement Request</h3>");
		pw.println("</div>");
		pw.println("<div id='rrForm' class='nodisplay'>HelloWorld!!</div></a>");
		
		pw.println("<a href='editInfo'><div class='xcontainer'>");
		pw.println("<h3>Edit Your Information</h3>");
		pw.println("</div></a>");
		
		pw.println("<div class='xcontainer' onclick='viewRR()'>");
		pw.println("<h3>View Reimbursement Requests</h3>");
		pw.println("</div>");
		pw.println("<div id='rrView'>");
		
		ArrayList<ReimbursementRequest> rrList;
		
		rrList = (ArrayList<ReimbursementRequest>) new ReimbursementRequestImpDao()
				.getReimbursementRequests(emp.getID());
		
		if(rrList.size() == 0) {
			pw.write("<h3> YOU HAVE NO REIMBURSEMENT REQUESTS </h3>");
		}
		else {
			pw.write("<div class='xcontainer2'><table>"
					+ "<thead>"
					+ "	 <th>EMPLOYEE ID</th>"
					+ "	 <th>REQUEST ID</th>"
					+ "  <th>QUANTITY</th>"
					+ "  <th>STATUS</th>"
					+ "</thead>");
			// go through list
			for(int i = 0; i < rrList.size(); i++) {
				ReimbursementRequest rr = rrList.get(i);
				pw.write("<tr>");
				int eid = emp.getID();
				int rrid = rr.getId();
				double quantity = rr.getQuantity();
				String status = rr.getStatus();
				
				pw.write("<td>"+eid+"</td>");
				pw.write("<td>"+rrid+"</td>");
				pw.write("<td>$"+quantity+"</td>");
				pw.write("<td>"+status+"</td>");
				pw.write("</tr>");
			}
			pw.write("</div></table>");
		}
		
	
		
		pw.println("</div>");
		
		

		
		pw.println("<script src='./js/myJavaScript.js'></script>");
		pw.println("</body>");
		pw.println("</html>");
	}
}
