package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		Person guy1 = new Person("Peter",9,"Leecher");
		Person guy2 = new Person("Chris",420,"God");
		ObjectMapper mapper = new ObjectMapper();
		List<Person> people = new ArrayList<>();
		people.add(guy);
		people.add(guy1);
		people.add(guy2);
		
		String jsonInString = mapper.writeValueAsString(people);
		resp.getWriter().write(jsonInString);
		/*
		 * var str = '{"a": 1, "b": 2, "c": 3}\n'+
          '{"a": 4, "b": 5, "c": 6}';
			var strLines = str.split("\n");
		 * 
		 */
	}
//[{"name":"John","age":22,"occupation":"Neet"},
	//{"name":"Peter","age":9,"occupation":"Leecher"},
	//{"name":"Chris","age":420,"occupation":"God"}]
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
		
		ObjectMapper mapper = new ObjectMapper();
		Person guy = new Person("Mary",22,"Teacher");
		List<Person> people = new ArrayList<>();
		people.add(guy);
		String jsonInString = mapper.writeValueAsString(people);
		resp.getWriter().write(jsonInString);
	}

}