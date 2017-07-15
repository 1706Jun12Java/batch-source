package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.domain.ReimbursementTicket;
import com.revature.domain.User;

public class AjaxReimInfo extends HttpServlet{

	public AjaxReimInfo() {
		// TODO Auto-generated constructor stub
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
		String line;

        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        
        String data = buffer.toString();
		System.out.println(data);
		
		int id=Integer.parseInt(data);
		ObjectMapper mapper = new ObjectMapper();
		UserDaoImpl userDao=new UserDaoImpl();
		
		User guy = userDao.getUserById(id);
		ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();
		List<ReimbursementTicket> tickets = rDao.getReimbursementTicketsByEmp(guy);
		String jsonInString = mapper.writeValueAsString(tickets);
		resp.getWriter().write(jsonInString);
	}
}
