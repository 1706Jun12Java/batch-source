package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLRecoverableException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.common.io.ByteStreams;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import DAO.*;
import Domain.RRequest;

public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			resp.setContentType("text/html");
			HttpSession sess = req.getSession();
			RequestDAO d = new RequestDAOImpl();
			PrintWriter pw = resp.getWriter();
			byte[] in = null;
			String b64;
			DecimalFormat format = new DecimalFormat("0.00");
			if (sess.getAttribute("role") == null) {
				return;
			}
			if (sess.getAttribute("role").toString().equals("employee")) {
				pw.println("<thead>");
				pw.println(
						"<tr><td><p>Receipt</p></td><td><p>Amount</p><td><p>Description</p></td></td><td><p>Submit Date</p></td><td><p>Resolver</p></td><td><p>Resolve Date</p></td><td><p>status</p></td><td><p>type</p></td><tr>");
				pw.println("</thead>");

				for (RRequest r : d.getRequests((String) sess.getAttribute("username"))) {
					switch (r.getStatus()) {
					case "pending":
						pw.println("<tr class=\"active\">");
						break;
					case "approved":
						pw.println("<tr class=\"success\">");
						break;
					case "rejected":
						pw.println("<tr class=\"danger\">");
						break;
					}
					if (r.getImage() != null) {
						in = ByteStreams.toByteArray(r.getImage());
						b64 = Base64.encode(in);
						pw.println("<td><a href=\"data:image/gif;base64," + b64 + "\" alt=\"Receipt\">Show</a></td>");
					} else {
						pw.print("<td>No Photo</td>");
					}
					String amtStr = format.format(r.getAmount());
					pw.println("<td>$" + amtStr + "</td>");
					pw.println("<td>" + r.getDesc() + "</td>");
					pw.println("<td>" + r.getSubmitted().toString() + "</td>");
					if (r.getResolver() != null) {
						pw.println("<td>" + r.getResolver() + "</td>");
					} else {
						pw.println("<td>n/a</td>");
					}
					if (r.getResolved() != null) {
						pw.println("<td>" + r.getResolved().toString() + "</td>");
					} else {
						pw.println("<td>n/a</td>");
					}
					pw.println("<td>" + r.getStatus() + "</td>");
					pw.println("<td>" + r.getType() + "</td>");
					pw.println("</tr>");
				}
			} else {
				pw.println("<form action=\"\">");
				pw.println("<thead>");
				pw.println(
						"<tr><td></td><td><p>Receipt</p><td><p>Author</p></td></td><td><p>Amount</p><td><p>Description</p></td></td><td><p>Submit Date</p></td><td><p>Resolver</p></td><td><p>Resolve Date</p></td><td><p>status</p></td><td><p>type</p></td><tr>");
				pw.println("</thead>");

				for (RRequest r : d.getRequests()) {
					switch (r.getStatus()) {
					case "pending":
						pw.println("<tr class=\"active\">");
						break;
					case "approved":
						pw.println("<tr class=\"success\">");
						break;
					case "rejected":
						pw.println("<tr class=\"danger\">");
						break;
					}
					if (r.getStatus().equals("pending")) {
						pw.println(
								"<td><input type=\"radio\"  name=\"toResolve\" value=\"" + r.getID() + "\"></td>");
					} else {
						pw.println("<td>      </td>");
					}
					if (r.getImage() != null) {
						in = ByteStreams.toByteArray(r.getImage());
						b64 = Base64.encode(in);
						pw.println("<td><a href=\"data:image/gif;base64," + b64 + "\" alt=\"Receipt\">Show</a></td>");
					} else {
						pw.print("<td>No Photo</td>");
					}
					pw.println("<td>" + r.getAuthor() + "</td>");
					String amtStr = format.format(r.getAmount());
					pw.println("<td>$" + amtStr + "</td>");
					pw.println("<td>" + r.getDesc() + "</td>");
					pw.println("<td>" + r.getSubmitted().toString() + "</td>");
					if (r.getResolver() != null) {
						pw.println("<td>" + r.getResolver() + "</td>");
					} else {
						pw.println("<td>n/a</td>");
					}
					if (r.getResolved() != null) {
						pw.println("<td>" + r.getResolved().toString() + "</td>");
					} else {
						pw.println("<td>n/a</td>");
					}
					pw.println("<td>" + r.getStatus() + "</td>");
					pw.println("<td>" + r.getType() + "</td>");
					pw.println("</tr>");
				}
				pw.println("<form>");
			}
		} catch (SQLRecoverableException e) {
			return;
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
