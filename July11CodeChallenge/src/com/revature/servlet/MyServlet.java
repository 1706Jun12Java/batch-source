package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		
		Person guy = new Person("John",22,"Neet");
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(guy);
		resp.getWriter().write(jsonInString);
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		Person guy = new Person("Mary",22,"Teacher");
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(guy);
		resp.getWriter().write(jsonInString);
	}

}