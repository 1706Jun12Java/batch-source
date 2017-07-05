package com.chase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chase.dao.BankAccountDaoImpl;
import com.chase.dao.UserDaoImpl;
import com.chase.exceptions.IncorrectAccountException;


public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DepositServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session  = request.getSession();
		
		String username = (String) session.getAttribute("username");
		int accountNum = Integer.parseInt(request.getParameter("accountnum"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		try{
			int u_Id = UserDaoImpl.getUserByUsername(username);
			BankAccountDaoImpl.deposit(u_Id, accountNum, amount);
			RequestDispatcher rd = request.getRequestDispatcher("depositconfirm.jsp");
			rd.forward(request, response);
		}
		catch (IncorrectAccountException e){
			RequestDispatcher rd = request.getRequestDispatcher("404.html");
			rd.include(request, response);
			pw.println(e.getMessage());;
		}
		pw.close();
	}

}
