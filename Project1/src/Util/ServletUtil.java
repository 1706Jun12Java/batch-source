package Util;

import java.io.*;
import javax.servlet.http.*;

public class ServletUtil {

	public ServletUtil() {
	}

	public static String process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		switch (req.getParameter("action")) {
		case "login":
			return "login";
		case "submit":
			return "submit.html";
		case "view":
			return "view";
		case "logout":
			return "logout";
		case "signup":
			return "signup";
		case "update":
			return "update";
		default:
			return "404.html";
		}
	}

}
