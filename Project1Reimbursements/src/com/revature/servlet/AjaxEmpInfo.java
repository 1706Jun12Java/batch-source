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
import com.revature.dao.UserDaoImpl;
import com.revature.domain.User;

public class AjaxEmpInfo extends HttpServlet{

	public AjaxEmpInfo() {
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
		if(id>0){
			ObjectMapper mapper = new ObjectMapper();
			UserDaoImpl userDao=new UserDaoImpl();
			
			User guy = userDao.getUserById(id);
			List<User> people = new ArrayList<>();
			people.add(guy);
			String jsonInString = mapper.writeValueAsString(people);
			resp.getWriter().write(jsonInString);
		}
		else{
			ObjectMapper mapper = new ObjectMapper();
			UserDaoImpl userDao=new UserDaoImpl();
			
			List<User> people = userDao.getUsers();
			String jsonInString = mapper.writeValueAsString(people);
			resp.getWriter().write(jsonInString);
		}
		
	}
}
