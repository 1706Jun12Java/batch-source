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

public class CDServlet extends HttpServlet{

	public CDServlet() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
	
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		HttpSession session = req.getSession();
		UserDaoImpl userDao=new UserDaoImpl();
		BankAccountDaoImpl bankDao=new BankAccountDaoImpl();
		User user=userDao.userLogin((String)session.getAttribute("username"), 
				(String)session.getAttribute("password"));
		pw.println("<p>Welcome, "+user.getFname()+"</p>");
		
		String op=req.getParameter("crde");
		List<BankAccount> b=bankDao.getBankAccountsByUser(user);
		if(op.equals("DeleteEmptyAccounts")){
			bankDao.DeleteAccs(user.getUserId());
			pw.println("<p>Deleted all empty bank account(s) if there were any</p> ");
		}
		else if(op.equals("CreateNewAccount")){
			bankDao.createBankAccount(user);
			pw.println("<p>Created a new bank account</p> ");
			pw.println("<p>It may take a while to show the updates</p> ");
		}
		if(b.size()==0){
			pw.println("<p>You have accounts to do that with</p> ");
		}
		req.getRequestDispatcher("superUser.html").include(req, res);
		if(b.size()!=0){
			pw.println("<h3>Your accounts:</h3> ");
			for(BankAccount ba: b){
				pw.println("<p>"+ba.toString()+"</p> ");
			}
		}
		if(user.getIsSuperUser().equals("F")){
			req.getRequestDispatcher("normalUser.html").include(req, res);
		}
		else{
			pw.println("<h3>ALL USERS IN THE DATABASE</h3> ");
			for(User u:userDao.getUsers()){
				pw.println("<p>"+u.toString()+"</p> ");
			}
		
		}
		
	}
}
