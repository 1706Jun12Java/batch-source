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

public class RegisterServlet extends HttpServlet{

	public RegisterServlet() {
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
		req.getRequestDispatcher("register.html").include(req, resp);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		

		HttpSession session = req.getSession();
		
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		UserDaoImpl userDao = new UserDaoImpl();
		User ruser=new User(username,password,fname,lname,"F");
		User user=userDao.registerUser(ruser);
		user=userDao.userLogin(username, password);
		if(user.getIsSuperUser().equals("F")){
			session.setAttribute("username", user.getUsername());
			session.setAttribute("password", user.getPassword());
			session.setAttribute("fname", user.getFname());
			session.setAttribute("lname", user.getLname());
			session.setAttribute("level", user.getIsSuperUser());
			pw.println("<p>Welcome, "+username+"</p>");
			List<BankAccount> banks =null;
			BankAccountDaoImpl bd = new BankAccountDaoImpl();
			banks=bd.getBankAccountsByUser(user);
			if(banks!=null){
				for(BankAccount ba: banks){
					pw.println("<p>"+ba.toString()+"</p> ");
				}
			}
			if(banks.size()==0){
				pw.println("<p>You have no bank accounts</p> ");
			}

			req.getRequestDispatcher("normalUser.html").include(req, res);
		}
		else{
			session.setAttribute("incorrect", "Account could not be made");
			res.sendRedirect("register");
		}
		
		
		
	}

}
