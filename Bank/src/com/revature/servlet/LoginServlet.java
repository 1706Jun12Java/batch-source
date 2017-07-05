package com.revature.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.User;

public class LoginServlet extends HttpServlet{

	public LoginServlet() {
		// TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession();
		resp.setContentType("text/html");
		String wasIncorrect = (String) session.getAttribute("incorrect");
		if (wasIncorrect != null){
			pw.println(wasIncorrect);
		}
		req.getRequestDispatcher("login.html").include(req, resp);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
	
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		

		HttpSession session = req.getSession();
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		UserDaoImpl userDao = new UserDaoImpl();
		User user=userDao.userLogin(username, password);
		if(user==null){
			session.setAttribute("incorrect", "Inccorect information, try again");
			res.sendRedirect("login");
		}
		
		
		else if(user.getIsSuperUser().equals("F")){
			
			session.setAttribute("username", user.getUsername());
			session.setAttribute("password", user.getPassword());
			session.setAttribute("fname", user.getFname());
			session.setAttribute("lname", user.getLname());
			session.setAttribute("level", user.getIsSuperUser());
			
			pw.println("<p>Welcome, "+user.getFname()+"</p>");
			
			req.getRequestDispatcher("normalUser.html").include(req, res);
			List<BankAccount> banks =null;
			BankAccountDaoImpl bd = new BankAccountDaoImpl();
			banks=bd.getBankAccountsByUser(user);
			pw.println("<h3>Your accounts:</h3> ");
			if(banks!=null){
				for(BankAccount ba: banks){
					pw.println("<p>"+ba.toString()+"</p> ");
				}
			}
			if(banks.size()==0){
				pw.println("<p>You have no bank accounts</p> ");
			}
			
		}
		else if(user.getIsSuperUser().equals("T")){
			session.setAttribute("username", user.getUsername());
			session.setAttribute("password", user.getPassword());
			session.setAttribute("fname", user.getFname());
			session.setAttribute("lname", user.getLname());
			session.setAttribute("level", user.getIsSuperUser());
			//res.sendRedirect("superUser.html");
			pw.println("<p>Welcome, "+user.getFname()+"</p>");
			req.getRequestDispatcher("superUser.html").include(req, res);
			List<BankAccount> banks =null;
			BankAccountDaoImpl bd = new BankAccountDaoImpl();
			banks=bd.getBankAccountsByUser(user);
			
			pw.println("<h3>Your accounts:</h3> ");
			if(banks!=null){
				for(BankAccount ba: banks){
					pw.println("<p>"+ba.toString()+"</p> ");
				}
			}
			if(banks.size()==0){
				pw.println("<p>You have no bank accounts</p> ");
			}
			pw.println("<h3>ALL USERS IN THE DATABASE</h3> ");
			for(User u:userDao.getUsers()){
				pw.println("<p>"+u.toString()+"</p> ");
			}
			
			
		}
		
	}
}
