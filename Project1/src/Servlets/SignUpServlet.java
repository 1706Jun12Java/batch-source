package Servlets;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.map.ObjectMapper;

import CustomExceptions.InvalidNameException;
import CustomExceptions.UserNameTakenException;
import DAO.ERUsersDAO;
import DAO.ERUsersDAOImpl;
import Domain.ERUser;

public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SignUpServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		try {
			StringBuilder buffer = new StringBuilder();
			BufferedReader reader = req.getReader();
			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			String data = buffer.toString();
			ObjectMapper map = new ObjectMapper();
			ERUser newUser = map.readValue(data, ERUser.class);
			ERUsersDAO erDAO = new ERUsersDAOImpl();
			if (erDAO.addUser(newUser)) {
				resp.getWriter().write("<p style=\"color:green\">User added successfully</p>");
			}
		} catch (UserNameTakenException e) {
			resp.getWriter().write("<p style=\"color:red\">Email is already used</p>");
		} catch (InvalidNameException e) {
			resp.getWriter().write("<p style=\"color:red\">Fields cannot be left blank</p>");
		} catch (Exception e) {
			System.out.println(e.getClass());
			System.out.println(e.getMessage());
		}
	}

}
