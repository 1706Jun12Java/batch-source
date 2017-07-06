package com.revature.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public RequestHelper() {
		
		// TODO Auto-generated constructor stub
	}

	public static String process(HttpServletRequest req, HttpServletResponse resp)throws IOException{
		switch(req.getParameter("")){
		case "login":
		return "login,html";
		case "logout":
			return "logout.html";
		case "View Account":
			return "profile.html";
			default:
				return "404.html";
		}
	}
}
