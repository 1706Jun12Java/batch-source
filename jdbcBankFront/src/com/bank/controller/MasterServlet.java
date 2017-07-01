package com.bank.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.bank.util.RequestHelper;

@SuppressWarnings("serial")
public class MasterServlet extends HttpServlet{
	@Override	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rh = RequestHelper.process(req, resp);
		resp.sendRedirect(rh);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rh = RequestHelper.process(req, resp);
		resp.sendRedirect(rh);
	}
}
