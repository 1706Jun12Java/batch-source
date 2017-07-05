package com.revature.leibniz.bank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.leibniz.bank.dao.AccountImpDao;
import com.revature.leibniz.bank.dao.PersonImpDao;
import com.revature.leibniz.bank.dao.UserImpDao;
import com.revature.leibniz.bank.domain.Account;
import com.revature.leibniz.bank.domain.Person;
import com.revature.leibniz.bank.domain.User;
import com.revature.leibniz.bank.util.DataUtil;

public class UserLoginServlet extends HttpServlet {

	@Override
	public void init() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		if (session.getAttribute("username") == null) {
			resp.sendRedirect("userlogin.html");
		} else {
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			String username = req.getParameter("username");
			String password = req.getParameter("password");

			boolean accessGranted = false;
			User user = null;
			ArrayList<User> users = (ArrayList<User>) new UserImpDao().getUsers();

			session = req.getSession();

			if (session.getAttribute("username") != null) {
				username = (String) session.getAttribute("username");
				password = (String) session.getAttribute("password");
			}

			for (int i = 0; i < users.size(); i++) {
				user = users.get(i);
				String xuser = user.getUsername();
				String xpass = user.getPassword();

				if (xuser.equals(username) && xpass.equals(password)) {
					accessGranted = true;
					break;
				}
			}

			if (accessGranted) {
				Person person = new PersonImpDao().getPersonByID(user.getPersonID());
				String firstname = person.getFirstname();
				String lastname = person.getLastname();

				Account account = new AccountImpDao().getAccountByID(person.getPersonID());

				session.setAttribute("username", username);
				session.setAttribute("password", password);

				pw.println("<h3>ACCESS GRANTED</h3>");
				pw.println("<h3>WELCOME " + firstname + " " + lastname + "</h3>");

				pw.println("<h5>Account Balance : $" + account.getBalance() + "</h5>");

				pw.println("<form action = \"withdraw\" method=\"post\">");
				pw.println("<input name =\"withdrawValue\">");
				pw.println("<input type =\"submit\" value=\"WITHDRAW\"><br>");
				pw.println("</form>");

				pw.println("<form action = \"deposit\" method=\"post\">");
				pw.println("<input name =\"depositValue\">");
				pw.println("<input type =\"submit\" value=\"DEPOSIT\">");
				pw.println("</form>");

				pw.println("<h5><a href =\"logout\">logout</a></h5>");

				DataUtil.accountID = account.getAccountID();
				DataUtil.balance = account.getBalance();
			} else {
				pw.println("<h3>ACCESS DENIED</h3>");
				pw.println("<h5><a href=\"index.html\">Go back</a></h3>");
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");

		boolean accessGranted = false;
		User user = null;
		ArrayList<User> users = (ArrayList<User>) new UserImpDao().getUsers();

		HttpSession session = req.getSession();

		if (session.getAttribute("username") != null) {
			username = (String) session.getAttribute("username");
			password = (String) session.getAttribute("password");
		}

		for (int i = 0; i < users.size(); i++) {
			user = users.get(i);
			String xuser = user.getUsername();
			String xpass = user.getPassword();

			if (xuser.equals(username) && xpass.equals(password)) {
				accessGranted = true;
				break;
			}
		}

		if (accessGranted) {
			Person person = new PersonImpDao().getPersonByID(user.getPersonID());
			String firstname = person.getFirstname();
			String lastname = person.getLastname();

			Account account = new AccountImpDao().getAccountByID(person.getPersonID());

			session.setAttribute("username", username);
			session.setAttribute("password", password);

			pw.println("<h3>ACCESS GRANTED</h3>");
			pw.println("<h3>WELCOME " + firstname + " " + lastname + "</h3>");

			pw.println("<h5>Account Balance : $" + account.getBalance() + "</h5>");

			pw.println("<form action = \"withdraw\" method=\"post\">");
			pw.println("<input name =\"withdrawValue\">");
			pw.println("<input type =\"submit\" value=\"WITHDRAW\"><br>");
			pw.println("</form>");

			pw.println("<form action = \"deposit\" method=\"post\">");
			pw.println("<input name =\"depositValue\">");
			pw.println("<input type =\"submit\" value=\"DEPOSIT\">");
			pw.println("</form>");

			pw.println("<h5><a href =\"logout\">logout</a></h5>");

			DataUtil.accountID = account.getAccountID();
			DataUtil.balance = account.getBalance();
		} else {
			pw.println("<h3>ACCESS DENIED</h3>");
			pw.println("<h5><a href=\"index.html\">Go back</a></h3>");
		}
	}

}
