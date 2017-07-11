package com.revature.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


public class CodeChallengeServlet extends HttpServlet{

	public CodeChallengeServlet() {
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
			doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			Person p = new Person("bob", "Electrician", "orange");
			Person p2 = new Person("Dylan", "Salesperson", "Green");
			Person p3 = new Person("George", "Pope", "Blue");
			ObjectMapper om = new ObjectMapper();
			resp.setContentType("application/json");
			Map<String, Person> map = new HashMap();
			map.put("person", p);
			map.put("person2", p2);
			map.put("person3", p3);
			String allPeople = om.writeValueAsString(map);
			resp.getWriter().println(allPeople);
			
			
			
	}
}
