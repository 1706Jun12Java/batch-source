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

public class WithdrawServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		AccountDAO acc = new AccountImpl();
		PrintWriter pw = resp.getWriter();
		if (acc.withdraw(Integer.parseInt((String) sess.getAttribute("account")),
				Double.parseDouble((String) sess.getAttribute("amount")))) {
			pw.println("<h1>Withdrawl successful</h1>");
		} else {
			pw.println("<h1>Withdrawl failed</h1>");
		}
		pw.println("<a href=\"Userpage.html\">return</a>");
		sess.setAttribute("account", null);
		sess.setAttribute("amount", null);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
