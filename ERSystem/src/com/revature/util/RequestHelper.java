package com.revature.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class RequestHelper {

	public RequestHelper() {
		// TODO Auto-generated constructor stub
	}
	
	public static String process(int num){
		
		switch(num){
		case 1:
			return "manage.html";
		case 2:
			return "profile.html";
		case 3:
			return "profile.html";
		default:
			return "404.html";
		}
		
	}
	
	public static String render(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		try{
			System.out.println(req.getParameter("destination"));
			switch(req.getParameter("destination")){
			case "getprofile":
				return "getprofile";
			case "login":
				return "login";
			case "logout":
				return "logout";
			case "manage":
				return "manage";
			case "getimage":
				return "getimage";
			case "gettickets":
				return "gettickets";
			case "getertypes":
				return "getertypes";
			default:
				return "404.html";
			}
		}catch(Exception e){
			return "404.html";
		}
		
	}

	
	public static <C> String getJSON(C cl) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		String json = mapper.writeValueAsString(cl);
		return json;
	}
}
