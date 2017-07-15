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

public class NewRTPage extends HttpServlet{

	public NewRTPage() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");

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
		req.getRequestDispatcher("load/createRT.html").include(req, resp);
		req.getRequestDispatcher("load/bot.html").include(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
