package com.ronwu.grocery;

import java.io.IOException;
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
 * Servlet implementation class groceryList
 */
@WebServlet("/groceryList")
public class GroceryList extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public GroceryList() {
        super();
        // TODO Auto-generated constructor stub
    }
 
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	resp.sendRedirect("index.html");
	}
 

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 
    	
    	String item = req.getParameter("item");
		String amount = req.getParameter("amount"); 
		
		System.out.println(item);   
		System.out.println(amount);  
		
		ShoppingItem new_item = new ShoppingItem(item, amount); 
		
		List<ShoppingItem> items = ReadWriteList.readList();
		items.add(new_item);
		ReadWriteList.writeList(items);
		
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(items);
		
		//System.out.println(json);
		
		resp.setContentType("application/json");
		PrintWriter pw = resp.getWriter();
		pw.print(json); 
	}

}
