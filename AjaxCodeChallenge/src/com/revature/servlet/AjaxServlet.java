package com.revature.servlet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		ObjectInputStream in = new ObjectInputStream(req.getInputStream());
		try {
			HashMap<String, String> myData = new HashMap<>();
			myData = (HashMap) in.readObject();
			PrintWriter pw = new PrintWriter(System.out);
			pw.println(myData);
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		in.close();
//		PrintWriter pw = new PrintWriter(System.out);
//		pw.println(myData);
//		ObjectOutputStream output = 
	}

}
