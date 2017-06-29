package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.revature.util.RequestHelper;

public class MasterServlet extends HttpServlet {

	public MasterServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rh = RequestHelper.process(req, resp);
		resp.sendRedirect(rh);
	}

}
