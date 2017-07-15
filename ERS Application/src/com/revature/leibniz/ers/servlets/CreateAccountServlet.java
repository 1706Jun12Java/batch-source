package com.revature.leibniz.ers.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.leibniz.ers.dao.EmployeeImpDao;
import com.revature.leibniz.ers.domain.Employee;
import com.revature.leibniz.ers.util.DataUtil;

public class CreateAccountServlet extends HttpServlet {

	// Default Constructor
	public CreateAccountServlet() {}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String email = req.getParameter("email");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		if(firstname.equals("") || lastname.equals("") || 
				email.equals("") || username.equals("") || password.equals("") ||
				cpassword.equals("")) {		
			DataUtil.printMessagePage(pw, "ERROR, empty fields not allowed", "createAccount.html", "Go Back" , 100);
			
		}
		else if(!password.equals(cpassword)) {
			DataUtil.printMessagePage(pw, "Password doesn't match confirmation-password", "createAccount.html", "Go Back" , 100);
		}
		
		else if(DataUtil.doesUserExist(username)) {			
			DataUtil.printMessagePage(pw, "USERNAME ALREADY EXIST", "createAccount.html", "Go Back" , 100);
		}
		else {	
			int id = DataUtil.getMaxInt("EMPLOYEE_TABLE", "EMPLOYEE_ID");
			
			Employee employee = new Employee()
					.setID(++id)
					.setFirstname(firstname)
					.setLastname(lastname)
					.setEmail(email)
					.setUsername(username)
					.setPassword(password)
					.setRole(Employee.EMPLOYEE_ROLE);
			int result = new EmployeeImpDao().createEmployee(employee);
			
			if(result==0) {
				DataUtil.printMessagePage(pw, "ACCOUNT CREATED", "index.html", "Go Home" , 105);
			}
			
		}
	}
}
