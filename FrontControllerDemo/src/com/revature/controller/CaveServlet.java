package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.*;
import com.revature.domain.*;

public class CaveServlet extends HttpServlet {

	public CaveServlet() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CaveDaoImpl cdl = new CaveDaoImpl();
		PrintWriter pw = response.getWriter();
		//List<Cave> cl = cdl.getCaves();
		for (Cave c : cdl.getCaves()){
			pw.println("<p>"+c.toString()+"</p>");
		}
		pw.println("<p>What am I?</p>");
		ServletConfig config = getServletConfig();
		pw.println("<p>"+config.getInitParameter("whatAmI")+"</p>");
		pw.println("<p>Where are we?</p>");
		pw.println("<p>"+config.getServletContext().getInitParameter("whereAreWe")+"</p>");

	}

}
