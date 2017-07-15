package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.E_User;

public class SignedIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SignedIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession(false);
		if(sess != null){
			E_User user = (E_User) sess.getAttribute("user");
			if(user.isManager()){
				response.getWriter().println("M");
				response.getWriter().println(user.getFirstName());
			} else {
				response.getWriter().println("E");
				response.getWriter().println(user.getFirstName());
			}
		} else {
			response.getWriter().println("");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
