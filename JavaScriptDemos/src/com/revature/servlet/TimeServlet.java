package com.revature.servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimeServlet extends HttpServlet {

	public TimeServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		LocalDateTime now = LocalDateTime.now();
		resp.getWriter().write("{\"hour\" : " + now.getHour() + ",\"minute\" : " + now.getMinute() + ",\"second\" : "
				+ now.getSecond() + "}");
	}

}
