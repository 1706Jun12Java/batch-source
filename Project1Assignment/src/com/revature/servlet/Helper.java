package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Helper {

	public Helper() {
		// TODO Auto-generated constructor stub
	}
	public static String reroute(HttpServletRequest req, HttpServletResponse resp){
		int serv = Integer.parseInt(req.getParameter("id"));
		String response = "";
		switch(serv){
		case 0: response = "/login";
		break;
		case 1: response = "/signedin";
		break;
		case 2: response = "/request";
		break;
		case 3: response = "/create";
		break;
		case 4: response = "/update";
		break;
		case 5: response = "/oneUser";
		break;
		case 99: response = "/logOut";
		break;
		}
		return response;
	}
}
