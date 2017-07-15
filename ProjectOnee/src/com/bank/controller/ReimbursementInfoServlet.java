package com.bank.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserDao;
import com.bank.dao.UserImpl;
import com.bank.user.Reimbursements;
import com.bank.user.Users;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
public class ReimbursementInfoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
		HttpSession session = req.getSession(false);
				
				
		if(session != null) {
			List<Reimbursements> list = new ArrayList<>();
			
			Users currentUser = (Users) session.getAttribute("user");
			UserDao user = new UserImpl();
			
			list = user.getReimbursements(currentUser.getU_ID(), currentUser.getRole());
			
			ObjectMapper mapper = new ObjectMapper();
			
			String objectToJson = mapper.writeValueAsString(list);
			
			resp.getWriter().write(objectToJson);
		} else {
			System.out.println("Error cant get user Reimbursements");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
