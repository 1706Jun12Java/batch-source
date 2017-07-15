package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserDaoImpl;
import com.bank.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		HttpSession session = request.getSession();
		
		String user = (String) session.getAttribute("username");
		int id = UserDaoImpl.getUserByUsername(user);
		User info = UserDaoImpl.viewEmployeeInfo(id);
		ObjectMapper map = new ObjectMapper();
		String json = map.writeValueAsString(info);
		System.out.println(json);
		response.getWriter().write(json);
	}


}
