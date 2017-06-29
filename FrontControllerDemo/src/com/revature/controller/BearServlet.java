package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.BearDaoImpl;
import com.revature.domain.Bear;

public class BearServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BearServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BearDaoImpl bdl = new BearDaoImpl();
		PrintWriter pw = response.getWriter();
		for (Bear b : bdl.getBears()){
			pw.println("<p>"+b.toString()+"</p>");
		}
		pw.println("<p>What am I?</p>");
		ServletConfig config = getServletConfig();
		pw.println("<p>"+config.getInitParameter("whatAmI")+"</p>");
		pw.println("<p>Where are we?</p>");
		pw.println("<p>"+config.getServletContext().getInitParameter("whereAreWe")+"</p>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
