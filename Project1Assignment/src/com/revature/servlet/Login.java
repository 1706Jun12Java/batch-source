package com.revature.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Exceptions.InvalidPasswordException;
import com.revature.Exceptions.InvalidUsernameException;
import com.revature.dao.E_UserImpl;
import com.revature.domain.E_User;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		E_UserImpl eui = new E_UserImpl();
	    BufferedReader reader = request.getReader();
	    String userName = reader.readLine();
	    String userPass = reader.readLine();
		response.setContentType("application/json");
		try {
			E_User user = eui.logIn(userName, userPass);
			if(user != null){
				HttpSession sess = request.getSession();
				sess.setAttribute("user", user);
				response.getWriter().println("success");
				response.getWriter().println("http://localhost:8080/Project1Assignment/Main.html");
			}
		} catch (InvalidUsernameException e) {
			// TODO Auto-generated catch block
			response.getWriter().println("");
			response.getWriter().println(e.getMessage());
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			response.getWriter().println("");
			response.getWriter().println(e.getMessage());
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
