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

public class RegistrationServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		
		pw.println("<head> <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\"><meta charset=\"UTF-8\"><title>Home Page</title></head>");
		pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"></head>");
		
		String errorMessage = (String) session.getAttribute("exists");
		if (errorMessage != null) {
			pw.println(errorMessage);
			session.setAttribute("exists",null);
			req.getRequestDispatcher("/home").include(req,  resp);
			return;
		}
			
		
		if(session!=null){
			req.getRequestDispatcher("register.html").include(req, resp);
		
	} else {
		resp.sendRedirect("accounts");
	}
		
	}
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		HttpSession session = req.getSession();
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		BankUserDao blid = new BankUserDaoImpl(); //bank user object
		
		int registerSuccess = blid.registerNewBankUser(username, password);
	
		if (registerSuccess!=0){
			pw.print("SUCCESS");
			int userId = blid.login(username, password);
			session.setAttribute("userId", userId);
			session.setAttribute("username", username);
			resp.sendRedirect("accounts");
			
		} else {
			session.setAttribute("exists", "This username already exists. Try another one!");
			resp.sendRedirect("home");
		}
		
	}

}
