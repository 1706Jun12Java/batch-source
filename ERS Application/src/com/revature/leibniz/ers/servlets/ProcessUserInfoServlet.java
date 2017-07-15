package com.revature.leibniz.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.leibniz.ers.domain.Employee;
import com.revature.leibniz.ers.util.DataUtil;

public class ProcessUserInfoServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {	
		myService(req, resp);
	}
	
	private void myService(HttpServletRequest req, HttpServletResponse resp) 
	throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		Employee emp = (Employee) session.getAttribute("employee");
		
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		
		if(firstname.equals("") && lastname.equals("")) {
			DataUtil.printMessagePage(pw, "ERROR: BLANK INPUT", "editInfo", "Go back");
		}
		else if(firstname.equals("")){
			// Update lastname
			DataUtil.updateEmployeeLastname(emp.getID(), lastname);	
			DataUtil.printMessagePage(pw, "LAST NAME UPDATED", "employee", "Go back");
		}
		else if(lastname.equals("")) {
			// Update firstname
			DataUtil.updateEmployeeFirstname(emp.getID(), firstname);
			DataUtil.printMessagePage(pw, "FIRST NAME UPDATED", "employee", "Go back");
		}
		else {
			// update both
			DataUtil.updateEmployeeLastname(emp.getID(), firstname);
			DataUtil.updateEmployeeLastname(emp.getID(), lastname);
			DataUtil.printMessagePage(pw, "FIRST & LAST NAME UPDATED", "employee", "Go back");
		}
	}
}
