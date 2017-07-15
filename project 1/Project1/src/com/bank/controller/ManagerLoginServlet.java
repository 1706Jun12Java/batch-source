package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserDaoImpl;

public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String username = request.getParameter("musername");
		String password = request.getParameter("mpassword");

		if (UserDaoImpl.validateManager(username, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("musername", username);
			RequestDispatcher rd = request.getRequestDispatcher("ManagerHomePage.jsp");
			rd.forward(request, response);
		} else {

			RequestDispatcher rd = request.getRequestDispatcher("ManagerLogin.html");
			rd.include(request, response);
			pw.println("Invalid Username or Password");
		}

		pw.close();
	}

}
