package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.BankAccount;
import com.revature.domain.User;

public class ShowAccounts extends HttpServlet{

	public ShowAccounts() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		PrintWriter pw=res.getWriter();
		HttpSession session = req.getSession();
		UserDaoImpl userDao=new UserDaoImpl();
		BankAccountDaoImpl bankDao=new BankAccountDaoImpl();
		User user=userDao.userLogin((String)session.getAttribute("username"), 
				(String)session.getAttribute("password"));
		List<BankAccount> banks =null;
		BankAccountDaoImpl bd = new BankAccountDaoImpl();
		banks=bd.getBankAccountsByUser(user);
		
		if(user.getIsSuperUser().equals("F")){
			pw.println("<p>Welcome, "+user.getFname()+"</p>");
			req.getRequestDispatcher("normalUser.html").include(req, res);
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
		}else{
			pw.println("<p>Welcome, "+user.getFname()+"</p>");
			req.getRequestDispatcher("superUser.html").include(req, res);
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
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
	
		
	}
}
