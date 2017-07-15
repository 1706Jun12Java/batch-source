package com.revature.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public RequestHelper() {
		// TODO Auto-generated constructor stub
	}
	public static String process(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		switch(req.getParameter("doThis")){
		case "Enter":
			return "loginPage";
		case "ChangeInfo":
			return "cinfoPage";
		case "View all Resolved Reimbursements":
			return "vAResolved";
		case "View all Pending Reimbursements":
			return "vAPending";
		case "View all Reimbursements":
			return "viewAllRT";
		case "View My Resolved Reimbursements":
			return "vMyResolved";
		case "View My Pending Reimbursements":
			return "vMyPending";
		case "Create a new ticket":
			return "newRTPage";
		case "View All Employee Info":
			return "vAEmp";
		default:
			return "404.html";
		}
		
	}
}
