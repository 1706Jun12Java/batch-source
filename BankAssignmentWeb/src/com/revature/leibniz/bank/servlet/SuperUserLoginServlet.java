package com.revature.leibniz.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.leibniz.bank.dao.PersonImpDao;
import com.revature.leibniz.bank.dao.SuperUserImpDao;
import com.revature.leibniz.bank.dao.UserImpDao;
import com.revature.leibniz.bank.domain.Person;
import com.revature.leibniz.bank.domain.SuperUser;
import com.revature.leibniz.bank.domain.User;

public class SuperUserLoginServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		boolean accessGranted = false;
		SuperUser superUser = null;
		ArrayList<SuperUser> superUsers = (ArrayList<SuperUser>) new SuperUserImpDao().getSuperUsers();
		
		for(int i = 0; i < superUsers.size(); i++) {
			String xuser = superUsers.get(i).getUsername();
			String xpass = superUsers.get(i).getPassword();
			
			if(xuser.equals(username) && xpass.equals(password)) {
				accessGranted = true;
				superUser = superUsers.get(i);
				break;
			}
		}
		Person person = new PersonImpDao().getPersonByID(superUser.getPersonID());
		if(accessGranted) {
			
			pw.println("<h3>ACCESS GRANTED</h3>");
			pw.println("<h4>Welcome "+ person.getFirstname() +"</h4>");
			pw.println("<h5><a href=\"viewBalance.html\">View Balance</a></h5>");
			pw.println("<h5><a href=\"withDrawl.html\">Withdrawl</a></h5>");
			pw.println("<h5><a href=\"deposit.html\">deposit</a></h5>");
		}
		else {
			pw.println("<h3>ACCESS DENIED</h3>");
			pw.println("<h5><a href=\"index.html\">Go back</a></h3>");
		}
		
		
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		
		
	}

}
