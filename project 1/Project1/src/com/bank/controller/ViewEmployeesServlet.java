package com.bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bank.dao.UserDaoImpl;
import com.bank.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ViewEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewEmployeesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		
			List<User> users = UserDaoImpl.getAllEmployees();
			ObjectMapper map = new ObjectMapper();
			String json = map.writeValueAsString(users);
			System.out.println(json);
			response.getWriter().write(json);
			
	}
}
