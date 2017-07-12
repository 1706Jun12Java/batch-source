package com.jackson.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jackson.person.Person;

@SuppressWarnings("serial")
public class PersonServlet extends HttpServlet{

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json");		
		Person p1 = new Person("Obama", "Test", 13);
		Person p2 = new Person("Obama2", "Test5", 17);
		Person p3 = new Person("Obama3", "Test6", 22);
		Person p4 = new Person("Obama4", "Test7", 50);
		Map<String, Object> map = new LinkedHashMap<>();
		
		map.put("p1", p1);
		map.put("p2", p2);
		map.put("p3", p3);
		map.put("p4", p4);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String objectToJson = mapper.writeValueAsString(map);
		
		resp.getWriter().write(objectToJson);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("application/json");
		
		StringBuilder buffer = new StringBuilder();
	    BufferedReader reader = req.getReader();
	    String line;

	    while ((line = reader.readLine()) != null) {
	        buffer.append(line);
	    }
	    
	    String data = buffer.toString();
	    System.out.println(data);
	    try {
	    	int age;
			String firstName = "";
			String lastName = "";

			ObjectMapper mapper = new ObjectMapper();

			JsonNode rootArray = mapper.readTree(data);


			for(JsonNode root : rootArray){
				firstName = root.path("firstName").asText();
				lastName = root.path("lastName").asText();
				age = root.path("age").asInt();


				System.out.println("firstName : " + firstName);
				System.out.println("lastName : " + lastName);
				System.out.println("age: " +  age);
			}
	    } catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
		}
	    
	}
	
}
