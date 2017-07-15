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

public class ApproveDenyServlet extends HttpServlet {

	public ApproveDenyServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		HttpSession session = req.getSession();
		
		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao .userLogin((String) session.getAttribute("username"),
				(String) session.getAttribute("password"));
		//System.out.println(user.toString());
		String rtId=req.getParameter("rtId");
		String doThis=req.getParameter("doThis");
		String msg=null;
		System.out.println(rtId+"  "+doThis);
		if(rtId==null){
			session.setAttribute("noChoice", "No ticket was picked");
			resp.sendRedirect("viewAllRT");
		}
		else{
			ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();
			ReimbursementTicket rt = rDao.getReimbursementTicketById(Integer.parseInt(rtId));
			if(doThis.equals("Approve")){
				rDao.approveTicket(rt, user);
				msg="Approved ticket number: "+rtId;
			}
			else{
				rDao.denyTicket(rt, user);
				msg="Denied ticket number: "+rtId;
			}
		}
		req.getRequestDispatcher("load/top.html").include(req, resp);
		req.getRequestDispatcher("load/nav.html").include(req, resp);
		pw.println("<div class='container col-md-8 col-md-offset-2'><h3 class='borderMe centerDiv'>"+msg+"</h3></div>");
		pw.println("<div class='col-md-12 centerDiv padTop'>"
				+ "<a href='viewAllRT'>View all Reimbursements</a></div");
		
		
		req.getRequestDispatcher("load/bot.html").include(req, resp);
	}

}
