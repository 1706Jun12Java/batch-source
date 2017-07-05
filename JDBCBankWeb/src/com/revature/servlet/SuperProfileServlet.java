package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.BankUserDao;
import com.revature.dao.BankUserDaoImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.BankUser;

public class SuperProfileServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		
		String superusername = (String) session.getAttribute("SuperUsername");
		
		pw.println("<head> <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\"><meta charset=\"UTF-8\"><title>Home Page</title></head>");

		pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"></head>");
		
		pw.println("<body><h3>Welcome " + superusername + "!</h3>");

		pw.println("<a class=\"btn btn-info\" href=\"logout\"> Logout</a>");
		pw.println("<h4>List of Gurung Bank Users</h4>");
		
		BankUserDao blid = new BankUserDaoImpl();
		
		for(BankUser user: blid.getUsers()){
			pw.println("<p>" + user.getUsername() + "</p>");
		}
		
		if(blid.getUsers().isEmpty()){
			pw.println("Looks like we have no users yet.<br>");
		} else{
		
		pw.println("<a class=\"btn btn-info text-danger\" href=\"deleteAllUsers\"> Delete All Bank Users?</a><br>");
		}
		pw.println("Create New User?<br>");
		
		pw.println("<form action = \"register\" method=\"post\">");
		pw.println("<div class=\"form-group\">");
		pw.println("<label for=\"username\">Username:</label>");
		pw.println("<input type=\"text\" class=\"form-control\" name=\"username\" id=\"username\">");
		pw.println("</div>");
		
		pw.println("<div class=\"form-group\">");
		pw.println("<label for=\"password\">Password:</label>");
		pw.println("<input type=\"password\" class=\"form-control\" name=\"password\" id=\"password\">");
		pw.println("</div>");
		 		
		pw.println("<button type=\"submit\" class=\"btn btn-primary\">Register</button>");
		pw.println("</form>");
		
		pw.println("</body>");
		
				
		
		
		
		
		
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		
//		String superusername = (String) session.getAttribute("SuperUsername");
		
//		deleteAllBankUsers
		
		
		
	}

}
