package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class ChangeInfoServlet extends HttpServlet {

	public ChangeInfoServlet() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ChangeInfoPage");
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();

		UserDaoImpl userDao = new UserDaoImpl();
		User user = userDao.userLogin((String) session.getAttribute("username"),
				(String) session.getAttribute("password"));
		String fname,lname,email;
		fname=req.getParameter("nfname");
		lname=req.getParameter("nlname");
		email=req.getParameter("nemail");
		if(fname.equals("")){
			fname=user.getU_fname();
		}
		if(lname.equals("")){
			lname=user.getU_lname();
		}
		if(email.equals("")){
			email=user.getU_email();
		}
		userDao.updateUser(user, fname, lname, email);
		resp.sendRedirect("employeeProfile");
	}
}
