package com.bank.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserDao;
import com.bank.dao.UserImpl;
import com.bank.user.Users;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("serial")
public class PendingServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json");
		HttpSession session = req.getSession(false);

		if(session != null) {
			Users currentUser = (Users) session.getAttribute("user");

			if (currentUser.getRole().equals("Manager")){
				StringBuilder buffer = new StringBuilder();
			    BufferedReader reader = req.getReader();
			    String line;
		
			    while ((line = reader.readLine()) != null) {
			        buffer.append(line);
			    }
			    
			    String data = buffer.toString();

			    UserDao user = new UserImpl();
			    try {
					String reimburseInfo = "";
					String reimburseId = "";
		
					ObjectMapper mapper = new ObjectMapper();
		
					JsonNode rootArray = mapper.readTree(data);
		
		
					for(JsonNode root : rootArray){
						reimburseInfo = root.path("reimburseInfo").asText();
						reimburseId = root.path("reimburseId").asText();
						user.updateReimbursements(Integer.parseInt(reimburseInfo), Integer.parseInt(reimburseId), currentUser.getU_ID());
					}
			    	resp.sendRedirect("profile");
			    } catch (Exception e) {
					// TODO: handle exception
			    	resp.sendRedirect("profile");
			    	e.printStackTrace();
				}
			} else{
				resp.sendRedirect("logout");
			}
		}else {
			resp.sendRedirect("logout");
		}
	}

}
