package com.revature.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestHelper {

	public RequestHelper() {
		// TODO Auto-generated constructor stub
	}
	
	public static String process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		switch(req.getParameter("destination")){
		case "login":
			return "login";
		case "logout":
			return "logout";
		case "main":
			return "main";
		default:
			return "404.html";
		}
		
	}
}
