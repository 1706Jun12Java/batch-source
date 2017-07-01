package com.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bank.dao.UserDao;
import com.bank.dao.UserImpl;
import com.bank.user.User;

@SuppressWarnings("serial")
public class SuperServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		HttpSession session = req.getSession(false);
		

		if(session != null) {
			
			try {
				User user = (User) session.getAttribute("user");
				String choice = req.getParameter("choice");
				if (user.getSuperUser() > 0){
					switch(choice){
						case "view":
							viewAllUser(user, resp);
							break;
						case "delete":
							deleteAllUser(user, resp);
							break;
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				resp.sendRedirect("login");
			}

			

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = resp.getWriter();

		try {
			int userid = Integer.parseInt(req.getParameter("userid"));
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			
	        UserDao userImpl = new UserImpl();
			
			System.out.println("Updating user");
			HttpSession session = req.getSession(false);


	        if (userImpl.updateUser(userid, username,password,email) ){

	        	resp.sendRedirect("profile");
	        }
	        else {
	        	pw.println("<div> Failed to update user </div>");
	        	pw.println("<div> <a href=\"logout\"> logout</a> </div>");
				pw.println("<div> <a href=\"profile\"> Back to Profile</a> </div>");
	        }
		} catch (Exception e) {
			pw.println("<div> Failed to update user </div>");
        	pw.println("<div> <a href=\"logout\"> logout</a> </div>");
			pw.println("<div> <a href=\"profile\"> Back to Profile</a> </div>");
		}

	}

    public static void viewAllUser(User user, HttpServletResponse resp) throws IOException{

        UserDao userImpl = new UserImpl();

        if(user.getSuperUser() > 0){
        	try {
        		PrintWriter pw = resp.getWriter();

                List<User> userList = userImpl.getUsers();

                for (User i: userList) {
                	pw.print("<div> " + i.toString() + " ");
                }
                
                pw.print("<div> <p>Update a user info!</p> </div>");
                
                pw.println("<form action=\"super\" method=\"post\">");
                
                pw.println("<input type=\"hidden\" name=\"choice\" value=\"view\">");
                pw.println("<input type=\"number\" placeholder=\"User ID\" name=\"userid\" >");
                pw.println("<input type=\"text\" placeholder=\"Email\" name=\"email\" >");
				pw.println("<input type=\"text\" placeholder=\"Username\" name=\"username\" >");
				pw.println("<input type=\"password\" placeholder=\"Password\" name=\"password\" >");
				
				pw.println("<input type=\"submit\" >"
						+ "</form>");
                
                pw.println("<div> <a href=\"logout\"> logout</a> </div>");
				pw.println("<div> <a href=\"profile\"> Back to Profile</a> </div>");
			} catch (Exception e) {
				resp.sendRedirect("profile");
			}
        }
    }


    public static void deleteAllUser(User user, HttpServletResponse resp){
        UserDao userImpl = new UserImpl();
        if (userImpl.deleteAllUser(user)){
			try {	
				resp.sendRedirect("logout");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

    }

}
