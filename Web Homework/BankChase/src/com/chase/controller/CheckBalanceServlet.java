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
		HttpSession session = request.getSession();
		
		int a_id = Integer.parseInt(request.getParameter("aId"));
		String username = (String) session.getAttribute("username");
		
		try {
			int u_Id = UserDaoImpl.getUserByUsername(username);
			Object balance = BankAccountDaoImpl.getBankAccountbyId(u_Id,a_id);
			session.setAttribute("CURRENT_BALANCE", balance);
			RequestDispatcher rd = request.getRequestDispatcher("checkbalanceconfirm.jsp");
			rd.forward(request, response);
		}
		catch(IncorrectAccountException e){
			RequestDispatcher rd = request.getRequestDispatcher("404.html");
			rd.include(request, response);
			pw.println(e.getMessage());
		}
		pw.close();
		
	}

}
