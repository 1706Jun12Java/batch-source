package com.jdbcbank.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbcbank.domain.Account;
 
@WebServlet(asyncSupported = true)
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
		 int account_id = Integer.parseInt(req.getParameter("account_id_delete"));
		 
		 System.out.println("deleting..");
		Account a = new Account(account_id);
		 
		try {
			a.removeAccountFromDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 System.out.println("deleted");
		 
		 //resp.sendRedirect("profile.html");
	}

}
