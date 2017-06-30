package Util;

import java.io.*;
import javax.servlet.http.*;

public class ServletUtil {

	public ServletUtil() {
		// TODO Auto-generated constructor stub
	}

	public static String process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		switch (req.getParameter("action")) {
		case "login":
			return "login";
		case "signup":
			return "signup";
		case "View":
			return "view";
		case "Manage":
			return "With_Desp.html";
		case "withdraw":
			return "withdraw";
		case "deposit":
			return "deposit";
		case "Create":
			return "create";
		case "Deleteh":
			return "Delete.html";
		case "Logout":
			return "logout";
		case "delete":
			return "delete";
		default:
			return "404.html";
		}
	}

}
