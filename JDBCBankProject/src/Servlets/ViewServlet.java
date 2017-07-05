package Servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import DAO.*;
import Domain.*;

public class ViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();
		AccountDAO acc = new AccountImpl();
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"stylez.css\" />");
		pw.println("<body><h1>These are all the accounts</h1><ul>");
		pw.println("<table style=\"width: 25%;\" border = \"1\"> <tbody>");
		if ((String) sess.getAttribute("admin") != null) {
			pw.println("<td>Username</td><td>Account #</td> <td>Amount</td>");
			for (Account a : acc.getAccounts()) {
				pw.println("<tr>");
				pw.println("<td>" + a.getUsername() + "</td><td>#" + a.getID() + "</td> <td>$" + a.getAmount()
						+ "</td>");
				pw.println("</tr>");
			}
			pw.println("</tbody> </table>");
		} else {
			pw.println("<td>Account #</td> <td>Amount</td>");
			for (Account a : acc.getAccounts((String) sess.getAttribute("username"))) {
				pw.println("<tr>");
				pw.println("<td>#" + a.getID() + "</td> <td>$" + a.getAmount() + "</td>");
				pw.println("</tr>");
			}
			pw.println("</tbody> </table>");
		}
		pw.println("<br><a href=\"Userpage.html\">return</a></body>");
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession();

	}

}
