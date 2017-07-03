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

public class WDServlet extends HttpServlet{

	public WDServlet() {
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
		int bankidnum=Integer.parseInt(req.getParameter("bankidnum"));
		int amount=Integer.parseInt(req.getParameter("amount"));
		String op=req.getParameter("operation");
		List<BankAccount> b=bankDao.getBankAccountsByUser(user);
		if(b.size()==0){
			pw.println("<p>You have accounts to do that with</p> ");
		}
		else{
			boolean has=false;
			for(BankAccount ba: b){
				if(ba.getBankAccountId()==bankidnum)
					has=true;
			}
			if(has==false){
				pw.println("<p>You have no accounts to do that with</p> ");
			}
			else{
				if(op.equals("withdraw")){
					bankDao.withdrawFromBank(user, bankidnum, amount);
					pw.println("<p>You withdrawn it may take a while for site to update</p> ");
				}
				else if(op.equals("deposit")){
					bankDao.depositToBank(user, bankidnum, amount);
					pw.println("<p>You deposited it may take a while for site to update</p> ");
				}
			}
			
		}

		req.getRequestDispatcher("superUser.html").include(req, res);
		if(b!=null){
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
