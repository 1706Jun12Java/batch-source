package Servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.codehaus.jackson.map.ObjectMapper;
import CustomExceptions.InvalidNameException;
import DAO.ERUsersDAO;
import DAO.ERUsersDAOImpl;
import MISC.PsuedoPair;

public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession sess = req.getSession();
		resp.getWriter().write("<p>Current First Name: " + sess.getAttribute("firstname")
				+ " </p><p>Current Last Name: " + sess.getAttribute("lastname") + "</p>");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		HttpSession sess = req.getSession();
		try {
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			String data = buffer.toString();
			ObjectMapper map = new ObjectMapper();
			PsuedoPair toUpdate = map.readValue(data, PsuedoPair.class);
			ERUsersDAO erDAO = new ERUsersDAOImpl();
			if (erDAO.updateUser((String) sess.getAttribute("username"), toUpdate.getSecond(), toUpdate.getFirst())) {
				resp.getWriter().write("<p style=\"color:green\">Updated successfully</p>");
				if (toUpdate.getSecond().equals("fname")) {
					sess.setAttribute("firstname", toUpdate.getFirst());
				}
				if (toUpdate.getSecond().equals("lname")) {
					sess.setAttribute("lastname", toUpdate.getFirst());
				}
			}
		} catch (InvalidNameException e) {
			resp.getWriter().write("<p style=\"color:red\">Fields cannot be left blank</p>");
		} catch (Exception e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
	}

}
