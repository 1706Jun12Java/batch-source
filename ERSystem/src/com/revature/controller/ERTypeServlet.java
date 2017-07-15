package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.dao.ERTypeDao;
import com.revature.dao.ERTypeDaoImpl;
import com.revature.domain.ReType;

public class ERTypeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7485944701264606679L;
	public ERTypeServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		ERTypeDao ED = new ERTypeDaoImpl();
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		PrintWriter pw = resp.getWriter();
		try{
			List<ReType> res = ED.getReTypes();
			String json = mapper.writeValueAsString(res);
			pw.write(json);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException{
		doGet(req,resp);
	}
}
