package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.Exceptions.InvalidAccountException;
import com.revature.Exceptions.OverDraftException;
import com.revature.domain.User;
import com.revature.main.ActionCaller;

/**
 * Servlet implementation class DepositWithdraw
 */
@WebServlet("/DepositWithdraw")
public class DepositWithdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DepositWithdraw() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession sess = request.getSession(false);
		User user = (User) sess.getAttribute("user");
		PrintWriter pw = response.getWriter();
		if(user!=null){
			String option = (String) request.getParameter("optradio2");
			if(option != null){
				String amount = request.getParameter("amount");
				String accountID = request.getParameter("ID");
				String action = option.toLowerCase();
				try {
					ActionCaller.updateAccount(user, accountID,amount,action);
				} catch (InvalidAccountException | OverDraftException e) {
					// TODO Auto-generated catch block
					request.getRequestDispatcher("404.html").include(request, response);
					pw.println(e.getMessage());
				}
				response.sendRedirect("signIn");
			} else{
				request.getRequestDispatcher("404.html").include(request, response);
				pw.println("No option was selected");
			}
			
		}else{
			request.getRequestDispatcher("404.html").include(request, response);
			pw.println("User was null");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
