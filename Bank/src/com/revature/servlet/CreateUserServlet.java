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

public class CreateUserServlet extends HttpServlet{

	public CreateUserServlet() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		
		PrintWriter pw = res.getWriter();
		HttpSession session = req.getSession();
		res.setContentType("text/html");
		String wasIncorrect = (String) session.getAttribute("incorrect");
		if (wasIncorrect != null){
			pw.println(wasIncorrect);
		}
		req.getRequestDispatcher("superUser.html").include(req, res);
		
		
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
		List<BankAccount> banks =null;
		BankAccountDaoImpl bd = new BankAccountDaoImpl();
		banks=bd.getBankAccountsByUser(user);
		
		String username=req.getParameter("cusername");
		String password=req.getParameter("cpassword");
		String fname=req.getParameter("cfname");
		String lname=req.getParameter("clname");
		User newuser=new User(username,password,fname,lname,"F");
		int created=userDao.createUser(user, newuser);
		

		
		if(created>0){
		pw.println("<p>You have created a new user; account may not show up immediately</p>");
		}
		else{
			pw.println("<p>Failed to create a new user</p>");
		}
		req.getRequestDispatcher("superUser.html").include(req, res);
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
