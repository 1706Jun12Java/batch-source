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
		pw.println("<link rel=\"stylesheet\" href=\"styles.css\"></head>");
		
		pw.println("<h3>Welcome " + superusername + "!</h3>");
		
		pw.println("<button type=\"button\" class=\"btn-primary\" style=\"color:#000000\"> <a href=\"logout\"> Logout</a> </button><br>");
		
		pw.println("<h4>List of Gurung Bank Users</h4>");
		
		BankUserDao blid = new BankUserDaoImpl();
		
		for(BankUser user: blid.getUsers()){
			pw.println("<p>" + user.getUsername() + "</p>");
		}
		
		pw.println("<button type=\"button\" class=\"btn-danger\"> <a href=\"deleteAllUsers\"> Delete All Bank Users?</a> </button><br>");
				
		
		
		
		
		
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
