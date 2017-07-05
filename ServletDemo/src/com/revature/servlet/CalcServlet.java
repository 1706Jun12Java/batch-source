package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
			System.out.println("did get");//on java side
			PrintWriter pw=resp.getWriter();
			
			
			String d1=req.getParameter("digitone");

			String d2=req.getParameter("digittwo");
				
			String op=req.getParameter("operation");
			
			String answer="";
			if(op.equals("add")){
				int x = Integer.parseInt(d1);
				int y= Integer.parseInt(d2);
				int z=x+y;
				answer=""+d1+"+"+d2+"="+z;
				//pw.println("<p>Hello, "+ d1+"+"+d2+"="+z+ "</p>");
			}
			if(op.equals("subtract")){
				int x = Integer.parseInt(d1);
				int y= Integer.parseInt(d2);
				int z=x-y;
				answer=""+d1+"-"+d2+"="+z;
				//pw.println("<p>Hello, "+ d1+"-"+d2+"="+z+ "</p>");
			}
			if(op.equals("multiply")){
				int x = Integer.parseInt(d1);
				int y= Integer.parseInt(d2);
				int z=x*y;
				answer=""+d1+"*"+d2+"="+z;
				//pw.println("<p>Hello, "+ d1+"*"+d2+"="+z+ "</p>");
			}
			if(op.equals("divide")){
				int x = Integer.parseInt(d1);
				int y= Integer.parseInt(d2);
				int z=x/y;
				answer=""+d1+"/"+d2+"="+z;
				//pw.println("<p>Hello, "+ d1+"/"+d2+"="+z+ "</p>");
			}
			//PrintWriter writes directly to the response page
			req.setAttribute("answerServlet", answer);
			RequestDispatcher rd = req.getRequestDispatcher("answerServlet");
			rd.forward(req, resp);
			//resp.sendRedirect("answerServlet");
			//pw.println("<a href=\"calc.html\"> go home</a>");
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
			System.out.println("did post");//on java side
			PrintWriter pw=resp.getWriter();
			
			
			String d1=req.getParameter("digitone");

			String d2=req.getParameter("digittwo");
				
			String op=req.getParameter("operation");
			String answer="";
			if(op.equals("add")){
				int x = Integer.parseInt(d1);
				int y= Integer.parseInt(d2);
				int z=x+y;
				answer=""+d1+"+"+d2+"="+z;
				pw.println("<p>Hello, "+answer+"</p>");
			}
			if(op.equals("subtract")){
				int x = Integer.parseInt(d1);
				int y= Integer.parseInt(d2);
				int z=x-y;
				answer=""+d1+"-"+d2+"="+z;
				//pw.println("<p>Hello, "+ d1+"-"+d2+"="+z+ "</p>");
				pw.println("<p>Hello, "+answer+"</p>");
			}
			if(op.equals("multiply")){
				int x = Integer.parseInt(d1);
				int y= Integer.parseInt(d2);
				int z=x*y;
				answer=""+d1+"*"+d2+"="+z;
				//pw.println("<p>Hello, "+ d1+"*"+d2+"="+z+ "</p>");
				pw.println("<p>Hello, "+answer+"</p>");
			}
			if(op.equals("divide")){
				int x = Integer.parseInt(d1);
				int y= Integer.parseInt(d2);
				int z=x/y;
				answer=""+d1+"/"+d2+"="+z;
				//pw.println("<p>Hello, "+ d1+"/"+d2+"="+z+ "</p>");
				pw.println("<p>Hello, "+answer+"</p>");
			}
			//PrintWriter writes directly to the response page
			System.out.println(answer);
			req.setAttribute("answerServlet", answer);
			RequestDispatcher rd = req.getRequestDispatcher("answerServlet");
			rd.forward(req, resp);
			//resp.sendRedirect("answerServlet");
			//pw.println("<a href=\"calc.html\"> go home</a>");
	}
}
