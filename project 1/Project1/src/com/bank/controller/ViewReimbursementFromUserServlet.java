package com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bank.dao.ReimbursementDaoImpl;
import com.bank.dao.UserDaoImpl;
import com.bank.domain.Reimbursement;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ViewReimbursementFromUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ViewReimbursementFromUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("application/json");
		
		String username = request.getParameter("userName");
		int id = UserDaoImpl.getUserByUsername(username);
		
		List<Reimbursement> reim = ReimbursementDaoImpl.getReimbursementByUsername(id);
		ObjectMapper map = new ObjectMapper();
		String json = map.writeValueAsString(reim);
		System.out.println(json);
		response.getWriter().write(json);
		
		
	}



}
