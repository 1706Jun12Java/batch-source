package com.chase.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chase.dao.BankAccountDaoImpl;

public class CheckBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckBalanceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int id = Integer.parseInt(request.getParameter("cbcb"));
		
		try {
			BankAccountDaoImpl.getBankAccountbyId(id);
			response.sendRedirect("checkbalanceforward.html");
			pw.println("Your current balance is: "+id);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		pw.close();
	}

}
