package com.revature.leibniz.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.leibniz.ers.domain.Employee;
import com.revature.leibniz.ers.util.DataUtil;
import com.revature.leibniz.ers.util.Debug;

public class LoginServlet extends HttpServlet{
	
	// Default Constructor
	public LoginServlet() {}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if(DataUtil.isAuthenticationGood(username, password)) {
			Debug.printMessage(this.getClass(), "doPost()", "AUTHENTICATION GOOD");
			Employee employee = DataUtil.getUser(username);
			session.setAttribute("employee", employee);
			
			RequestDispatcher rd = req.getRequestDispatcher("employee");
			rd.forward(req, resp);
		}
		else {
			Debug.printMessage(this.getClass(), "doPost()", "AUTHENTICATION FAILS");
			DataUtil.printMessagePage(pw,"ACCESS DENIED", "index.html", "Go back");			
		
		}
		
	}

}
