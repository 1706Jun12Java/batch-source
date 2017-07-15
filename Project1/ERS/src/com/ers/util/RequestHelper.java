package com.ers.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		switch(req.getParameter("route")){
		case "login":
			return "login";
		case "logout":
			return "logout";
		case "employee-profile":
			return "employee-profile";
		case "manager-profile":
			return "manager-profile";
		case "reimbursementform":
			return "reimbursementform";
		default:
			return "404.html";
				
		}
	}

}
