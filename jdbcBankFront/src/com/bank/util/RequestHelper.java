package com.bank.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static String process(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		switch(req.getParameter("")){
		default:
			return "404.html";
		}
	}

}
