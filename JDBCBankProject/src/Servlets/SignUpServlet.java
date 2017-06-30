package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.BankUserDAO;
import DAO.BankUserImpl;

public class SignUpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		BankUserDAO bk = new BankUserImpl();
		String user = (String) sess.getAttribute("username");
		String pass = (String) sess.getAttribute("password");
		PrintWriter pw = resp.getWriter();
		if (bk.addUser(user, pass)) {
			resp.sendRedirect("index.html");
		} else {
			resp.sendRedirect("FailedSignUp.html");
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
