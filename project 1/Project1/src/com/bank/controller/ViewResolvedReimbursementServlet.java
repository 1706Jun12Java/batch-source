package com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.ReimbursementDaoImpl;
import com.bank.dao.UserDaoImpl;
import com.bank.domain.Reimbursement;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ViewResolvedReimbursementServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    public ViewResolvedReimbursementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("application/json");
		HttpSession session = request.getSession();
		
		String user = (String) session.getAttribute("username");
		int id = UserDaoImpl.getUserByUsername(user);	
		List<Reimbursement> reim = ReimbursementDaoImpl.viewResolvedReimbursements(id);
		ObjectMapper map = new ObjectMapper();
		String json = map.writeValueAsString(reim);
		System.out.println(json);
		response.getWriter().write(json);
	}
		
}
