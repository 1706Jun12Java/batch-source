package com.revature.util;

import java.io.IOException;

import javax.servlet.http.*;

public class RequestHelper {

	public RequestHelper() {
		// TODO Auto-generated constructor stub
	}
	
	public static String process (HttpServletRequest req, HttpServletResponse resp) throws IOException {
		switch(req.getParameter("destination")){
		case "bears":
			return "bear";
		case "caves":
			return "cave";
		default:
			return "404.html";
		}
	}

}
