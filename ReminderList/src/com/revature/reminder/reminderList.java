package com.revature.reminder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

/**
 * Servlet implementation class reminderList
 */
@WebServlet("/reminderList")
public class reminderList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public reminderList() {
        super();
      
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("index.html"); 
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* 
		String body = request.getReader().lines().reduce("", (accumulator, actual) -> accumulator + actual);
		System.out.println(body);
		*/
		String reminder = request.getParameter("reminder");
		String date = request.getParameter("date");
		
		reminderItem r = new reminderItem(reminder,date);
		List<reminderItem> items = fileIO.readFile(); 
		items.add(r);
		fileIO.writeFile(items);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(items);
		response.setContentType("application/json");
		PrintWriter pw = response.getWriter();
		pw.print(json);
		
		
	}

}
