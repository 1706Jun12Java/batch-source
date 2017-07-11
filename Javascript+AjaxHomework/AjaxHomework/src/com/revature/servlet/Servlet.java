package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("application/json");
			ObjectMapper map = new ObjectMapper();
			String input = "{\"message\":\"This is a message from\",\"method\":\"GET \"}";
			ToConvert tc = map.readValue(input, ToConvert.class);
			resp.getWriter().write(tc.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			String data = buffer.toString();
			ObjectMapper map = new ObjectMapper();
			ToConvert tc = map.readValue(data, ToConvert.class);
			resp.getWriter().write(tc.toString());
		} catch (Exception e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}

	}

}
