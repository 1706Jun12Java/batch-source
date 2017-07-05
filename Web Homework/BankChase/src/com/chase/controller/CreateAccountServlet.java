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

public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CreateAccountServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		
		double amount = Double.parseDouble(request.getParameter("money"));
		String username = (String) session.getAttribute("username");
		
		try{
			int u_Id = UserDaoImpl.getUserByUsername(username);
			BankAccountDaoImpl.createBankAccount(u_Id,amount);
			RequestDispatcher rd = request.getRequestDispatcher("createaccountconfirm.jsp");
			rd.forward(request, response);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		pw.close();
	}

}
