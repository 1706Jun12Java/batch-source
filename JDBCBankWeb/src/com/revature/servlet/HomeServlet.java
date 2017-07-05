package com.revature.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.BankUserDao;
import com.revature.dao.BankUserDaoImpl;
import com.revature.util.ConnectionUtil;

public class HomeServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("text/html");

		pw.println("<head> <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\"><meta charset=\"UTF-8\"><title>Home Page</title></head>");
		pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"></head>");
		
		String errorMessage = (String) session.getAttribute("incorrect");
		if (errorMessage != null) {
			pw.println(errorMessage);
			session.setAttribute("incorrect",null);
		}
		req.getRequestDispatcher("home.html").include(req, resp);
		
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
		
		Properties prop = new Properties();
		InputStream in = ConnectionUtil.class.getResourceAsStream("connection.properties");
		prop.load(in);
		String url = prop.getProperty("url");
		String superusername = prop.getProperty("superusername");
		String superpassword = prop.getProperty("superpassword");
		
		
		
		
		
		if (username.equals(superusername) && password.equals(superpassword)){
			pw.print("SUCCESS");
			session.setAttribute("SuperUsername", superusername);
			session.setAttribute("incorrect", null);
			resp.sendRedirect("superprofile");
		}
		
		else if (blid.login(username, password) !=0){
			pw.print("SUCCESS");
			int userId = blid.login(username, password);
			session.setAttribute("userId", userId);
			session.setAttribute("username", username);
			session.setAttribute("incorrect",null);
			resp.sendRedirect("accounts");
			
		}
		
		else {
			session.setAttribute("incorrect", "Invalid username/ password");
			resp.sendRedirect("home");
		}
		
	}

}
