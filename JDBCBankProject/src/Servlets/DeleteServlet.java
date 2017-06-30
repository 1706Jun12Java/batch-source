package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AccountDAO;
import DAO.AccountImpl;

public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		AccountDAO acc = new AccountImpl();
		PrintWriter pw = resp.getWriter();
		if (acc.deleteAccount(Integer.parseInt((String) sess.getAttribute("account")))) {
			pw.println("<h1>Deletion successful</h1>");
		} else {
			pw.println("<h1>Deletion failed</h1>");
		}
		pw.println("<a href=\"Userpage.html\">return</a>");
		sess.setAttribute("account", null);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
