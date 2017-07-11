package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.domain.Employee;

public class CodeChallengeServlet extends HttpServlet{
	
	public CodeChallengeServlet(){}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 80810347981496643L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		resp.setContentType("application/json");
		List<Employee> employees = new ArrayList();
		employees.add(new Employee("john","john@gmail.com"));
		employees.add(new Employee("jerry","jerry@gmail.com"));
		employees.add(new Employee("fam","fam@gmail.com"));
		employees.add(new Employee("tom","tom@gmail.com"));
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String arrayToJson = mapper.writeValueAsString(employees);
		resp.getWriter().write(arrayToJson);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		resp.setContentType("application/json");
		resp.getWriter().write("you sent " + req.getParameter("name")+ req.getParameter("email"));
	}
	
}
