package com.chase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chase.dao.BankAccountDaoImpl;


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
		
		String userId = request.getParameter("idid");
		String accountNum = request.getParameter("accountnum");
		String amountt = request.getParameter("amount");
		int u_id = Integer.parseInt(userId);
		int acc_num = Integer.parseInt(accountNum);
		int amount = Integer.parseInt(amountt);
		
		try{
			BankAccountDaoImpl.deposit(u_id, acc_num, amount);
			RequestDispatcher rd = request.getRequestDispatcher("withdrawconfirm.html");
			rd.forward(request, response);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		pw.close();
	}

}
