package com.revature.bank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.bank.dao.AccountDao;
import com.revature.bank.dao.AccountDaoImpl;
import com.revature.bank.dao.TransactionDao;
import com.revature.bank.dao.TransactionDaoImpl;
import com.revature.bank.domain.Account;
import com.revature.bank.domain.Transaction;

public class UserServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -426150413464772879L;

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		resp.setContentType("text/html");
		HttpSession session = req.getSession(false);
		if(session==null){
			resp.sendRedirect("login.html");
		}
		System.out.println(session);
		int id = -1;
		String wasIncorrect = null;
		try{
			id = (Integer) session.getAttribute("userID");
			wasIncorrect = (String) session.getAttribute("incorrect");
			if(id<0){
				resp.sendRedirect("login.html");
			}
		}catch(Exception e){
			resp.sendRedirect("404.html");
		}
		AccountDao AD = new AccountDaoImpl();
		TransactionDao TD = new TransactionDaoImpl();
		
		req.setAttribute("error", wasIncorrect);
		try{
			List<Account> LA = AD.getAccountByUserId(id);
			ArrayList<List<Transaction>> TransLists = new ArrayList<List<Transaction>>();
			for(Account a:LA){
				TransLists.add(TD.getTransactions(a.getAcID()));
			}
			req.setAttribute("TransLists", TransLists);
			req.setAttribute("accounts", LA);
			req.getRequestDispatcher("profile.jsp").forward(req, resp);
		}catch(Exception e){
			e.printStackTrace();
			resp.sendRedirect("404.html");
		}
	}
	
	
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {

		HttpSession session = req.getSession(false);
		int id = (Integer) session.getAttribute("userID");
		String submit = req.getParameter("submit");
		AccountDao AD = new AccountDaoImpl();
		switch(submit){
			case "deposite":
				try{
					int acID = Integer.parseInt(req.getParameter("acID"));
					double amount = Double.parseDouble(req.getParameter("amount"));
					if (amount<=0.0){
						session.setAttribute("incorrect", "give a positive number");
						resp.sendRedirect("profile");
					}else{
						int deposite = AD.deposite(acID, amount);
						if(deposite==1){
							session.setAttribute("incorrect", null);
							resp.sendRedirect("profile");
							break;
						}else{
							session.setAttribute("incorrect", "unable to deposite at this time");
							resp.sendRedirect("profile");
						}
					}
					break;
				}catch(Exception e){
					req.getRequestDispatcher("404.html").include(req,resp);
				}
				break;
			case "withdraw":
				try{
					int acID = Integer.parseInt(req.getParameter("acID"));
					double amount = Double.parseDouble(req.getParameter("amount"));
					int withdraw = AD.withdraw(acID, amount);
					if(amount<=0.0){
						session.setAttribute("incorrect", "positive number! Okay!");
						resp.sendRedirect("profile");
					}
					if(withdraw==1){
						session.setAttribute("incorrect", null);
						resp.sendRedirect("profile");
						break;
					}else{
						session.setAttribute("incorrect", "unable to withdraw at this time");
						resp.sendRedirect("profile");
					}
					break;
				}catch(Exception e){
					req.getRequestDispatcher("404.html").include(req,resp);	
				}
				break;
			case "delete":
				try{
					int acID = Integer.parseInt(req.getParameter("acID"));
					int deleted = AD.deleteAccount(id, acID);
					if(deleted==0){
						session.setAttribute("incorrect", null);
						resp.sendRedirect("profile");
						break;
					}else{
						System.out.println("unable to delete");
						session.setAttribute("incorrect", "account balance > 0");
						resp.sendRedirect("profile");
					}
					break;
				}catch(Exception e){
					req.getRequestDispatcher("404.html").include(req,resp);	
				}
				break;
			case "create":
				try{
					int create = AD.createAccount(id);
					if(create==1){
						session.setAttribute("incorrect", null);
						resp.sendRedirect("profile");
						break;
					}else{
						session.setAttribute("incorrect", "unable to create at this time");
						resp.sendRedirect("profile");
					}
					break;
				}catch(Exception e){
					req.getRequestDispatcher("404.html").include(req,resp);				}
				break;
			}
		}
	
}
