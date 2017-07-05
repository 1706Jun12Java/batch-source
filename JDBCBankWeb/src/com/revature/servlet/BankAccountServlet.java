package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.BankAccountDao;
import com.revature.dao.BankAccountDaoImpl;
import com.revature.dao.BankUserDao;
import com.revature.dao.BankUserDaoImpl;
import com.revature.domain.BankAccount;

public class BankAccountServlet extends HttpServlet {
	
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(false);
		if(session!=null){
			String username = (String) session.getAttribute("username");
			int userId = (int) session.getAttribute("userId");
			int acctId = (int) session.getAttribute("bankAccountId");
			BigDecimal balance = (BigDecimal) session.getAttribute("bankAccountBalance");
			
			pw.println("<head> <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\"><meta charset=\"UTF-8\"><title>Home Page</title></head>");
			pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\"></head>");
			
			String errorMessage = (String) session.getAttribute("error");
			if (errorMessage != null) {
				pw.println(errorMessage);
				session.setAttribute("error",null);
				req.getRequestDispatcher("/myaccount").include(req, resp);
				return;
			}

			pw.println("<body><div class=\"greeting\">Hello, "+ username + "</div>");
			pw.println("<a class=\"btn btn-info\" href=\"accounts\"> Home</a>");
			pw.println("<a class=\"btn btn-info\" href=\"logout\"> Logout</a><br>");

			
			BankAccountDao baid = new BankAccountDaoImpl();
			pw.println("<head> <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\"><meta charset=\"UTF-8\"><title>Home Page</title></head>");
			pw.println("<h4> Bank Account:" + acctId + "</h4>");
			pw.println("<p>Details</p>");
			pw.println("<p>Account Id: " + acctId + "&emsp; &emsp; &emsp; &emsp;");
			pw.println("Balance: $" + balance + "</p>");
			
			pw.println("<form method=\"post\">");
			pw.println("<div class=\"smallheader\">Transaction</div><br>");
			pw.println("Amount($): <input type=\"text\" name=\"amount\"> &emsp;&emsp;");
			pw.println("<input type=\"radio\" name=\"transaction\" value=\"deposit\">Deposit");
			pw.println("<input type=\"radio\" name=\"transaction\" value=\"withdraw\">Withdraw");
			pw.println("<button type=\"submit\" class=\"btn btn-primary\">Submit</button>");
			pw.println("</form>");
			
			session.setAttribute("userId", userId);
			session.setAttribute("acctId", acctId);
			
			pw.println("<a class=\"btn btn-info\" href=\"deleteaccount\"> Delete This Bank Account</a>");
			
			pw.println("</body>");




			
			

		}
	}
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		
		
		HttpSession session = req.getSession(false);
		
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		
		String amount = req.getParameter("amount");
		BigDecimal amt = new BigDecimal(amount);
		String transaction = req.getParameter("transaction");
		
		BankAccountDao baid = new BankAccountDaoImpl();
		
		int userId = (int) session.getAttribute("userId");
		int acctId = (int) session.getAttribute("bankAccountId");
		BigDecimal balance = (BigDecimal) session.getAttribute("bankAccountBalance");
						
		
		session.setAttribute("userId", userId);
		session.setAttribute("acctId", acctId);
		session.setAttribute("acctBalance", balance);
		session.setAttribute("depositError", null);
				
		if(session!=null && transaction.equals("deposit")){
			if (amt.compareTo(BigDecimal.valueOf(0))==-1){				
				session.setAttribute("error", "You can't deposit a negative amount");
				resp.sendRedirect("myaccount");
			}
			else {
			baid.deposit(userId,acctId, amt);
			resp.sendRedirect("accounts");
			}
		}
		
		else if(session!=null && transaction.equals("withdraw")){
			if (amt.compareTo(BigDecimal.valueOf(0))==-1){				
				session.setAttribute("error", "You can't withdraw a negative amount");
				resp.sendRedirect("myaccount");
			}
			else {
			baid.withdraw(userId, acctId, amt);
			resp.sendRedirect("accounts");
			}
		}
		
	}

}


