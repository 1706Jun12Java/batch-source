package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.ReimbursementTicket;
import com.revature.domain.User;

public class ViewMyResolvedRT extends HttpServlet{

	public ViewMyResolvedRT() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();

		req.getRequestDispatcher("load/top.html").include(req, resp);
		req.getRequestDispatcher("load/nav.html").include(req, resp);
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.userLogin((String) session.getAttribute("username"),
				(String) session.getAttribute("password"));
		pw.println("<div class='container col-md-12'>");
		pw.println("<div class='col-md-3 .col-md-offset-3 centerDiv padTop'><b class='borderMe'>"
				+ "<span>User ID: </span><span id='empId'>" + user.getU_id() + "</span>" + "; Welcome, "
				+ user.getU_fname() + "</b></div>");
		pw.println("</div><br><br><br><br>");
		req.getRequestDispatcher("load/myRT.html").include(req, resp);
		pw.println("<br><div class='container col-md-8 col-md-offset-2'>");
		pw.println("<table class=table>");
		pw.println("<thead><tr><th colspan='10'>My Resolved Reimbursement Tickets</th></tr></thead>");
		pw.println("<tbody>");
		
		ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();
		List<ReimbursementTicket> tickets = rDao.getReimbursementTicketsByEmp(user);
		pw.println("<tr>");
		pw.println("<td>Id</td>");
		pw.println("<td>Amount</td>");
		pw.println("<td>Description</td>");
		pw.println("<td>Receipt</td>");
		pw.println("<td>Submitted</td>");
		pw.println("<td>Resolved</td>");
		pw.println("<td>ResolverId</td>");
		pw.println("<td>TicketType</td>");
		pw.println("<td>TicketStatus</td>");
		
		pw.println("</tr>");
		for(ReimbursementTicket rt : tickets){
			if(rt.getR_status()>1){
				pw.println("<tr>");
				pw.println("<td>"+rt.getR_id()+"</td>");
				pw.println("<td>"+rt.getR_amount()+"</td>");
				pw.println("<td>"+rt.getR_description()+"</td>");
				pw.println("<td><a href='viewImage?id="+rt.getR_id()+"'>Receipt</a></td>");
				pw.println("<td>"+rt.getSubmitted()+"</td>");
				pw.println("<td>"+rt.getResolved()+"</td>");
				pw.println("<td>"+rt.getU_id_resolver()+"</td>");
				pw.println("<td>"+rDao.getReimbursementTicketType(rt)+"</td>");
				pw.println("<td>"+rDao.getReimbursementTicketStatus(rt)+"</td>");
				
				pw.println("</tr>");
			}
			
		}
		pw.println("</tbody>");
		pw.println("</table>");
		pw.println("</div>");
		req.getRequestDispatcher("load/bot.html").include(req, resp);
	
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
