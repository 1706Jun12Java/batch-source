package com.bank.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		switch(req.getParameter("route")){
		case "information":
			return "information";
		case "login":
			return "login";
		case "view":
			return "view";
		default:
			return "404.html";
		}
	}

}