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

public class UpdateEmployeeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		String user = (String) session.getAttribute("username");
		int id = UserDaoImpl.getUserByUsername(user);

		if (username != null){
				UserDaoImpl.updateEmployeeUsername(username, id);
				session.setAttribute("username", username);
				RequestDispatcher rd = request.getRequestDispatcher("EmployeeUpdate.jsp");
				rd.include(request, response);
				pw.print("<script>var p1 = document.getElementById('p1');"
						+ "p1.innerHTML = 'Successfully Updated Account';"
						+ "setTimeout(function(){ p1.innerHTML='' }, 2000);</script>");
				}	
		if(password != null){
			UserDaoImpl.updateEmployeePassword(password, id);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeUpdate.jsp");
			rd.include(request, response);
			pw.print("<script>var p1 = document.getElementById('p1');"
					+ "p1.innerHTML = 'Successfully Updated Account';"
					+ "setTimeout(function(){ p1.innerHTML='' }, 2000);</script>");
		}
		if(firstname != null){
			UserDaoImpl.updateEmployeeFirstName(firstname, id);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeUpdate.jsp");
			rd.include(request, response);
			pw.print("<script>var p1 = document.getElementById('p1');"
					+ "p1.innerHTML = 'Successfully Updated Account';"
					+ "setTimeout(function(){ p1.innerHTML='' }, 2000);</script>");
		}
		if(lastname != null){
			UserDaoImpl.updateEmployeeLastName(lastname, id);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeUpdate.jsp");
			rd.include(request, response);
			pw.print("<script>var p1 = document.getElementById('p1');"
					+ "p1.innerHTML = 'Successfully Updated Account';"
					+ "setTimeout(function(){ p1.innerHTML='' }, 2000);</script>");
		}
		if(email != null){
			UserDaoImpl.updateEmployeeEmail(email, id);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeUpdate.jsp");
			rd.include(request, response);
			pw.print("<script>var p1 = document.getElementById('p1');"
					+ "p1.innerHTML = 'Successfully Updated Account';"
					+ "setTimeout(function(){ p1.innerHTML='' }, 2000);</script>");
		}

	}
}
