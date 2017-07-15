package com.revature.main;


import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import com.revature.dao.*;
import com.revature.domain.*;

public class Driver {

	public static void main(String[] args) {
		UserDaoImpl userDao = new UserDaoImpl();
		ReimbursementDaoImpl rtDao=new ReimbursementDaoImpl();
		/*
		for(User u:userDao.getUsers()){
			System.out.println(u.toString());
			if(userDao.isManager(u)){
				System.out.println("I am a manager");
			}
			System.out.println("my tickets");
			for(ReimbursementTicket rt : rtDao.getReimbursementTicketsByEmp(u)){
				System.out.println(rt.toString());
			}
		}
		
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		Timestamp ts=new Timestamp(now.getTime());
		System.out.println(ts.toString());
		
		
		for(ReimbursementTicket rt : rtDao.getReimbursementTickets()){
			System.out.println(rtDao.getReimbursementTicketStatus(rt));
			System.out.println(rtDao.getReimbursementTicketType(rt));
		}
		
		User manager = userDao.userLogin("Admin", "Password");
		System.out.println("APPROVE ALL");
		for(ReimbursementTicket rt : rtDao.getReimbursementTickets()){
			rtDao.approveTicket(rt,manager);
		}
		for(ReimbursementTicket rt : rtDao.getReimbursementTickets()){
			System.out.println(rtDao.getReimbursementTicketStatus(rt));
			System.out.println(rtDao.getReimbursementTicketType(rt));
		}
		System.out.println("Deny ALL ");
		for(ReimbursementTicket rt : rtDao.getReimbursementTickets()){
			rtDao.denyTicket(rt, manager);
		}
		for(ReimbursementTicket rt : rtDao.getReimbursementTickets()){
			System.out.println(rtDao.getReimbursementTicketStatus(rt));
			System.out.println(rtDao.getReimbursementTicketType(rt));
		}
		File file = new File(".");
		for(String fileNames : file.list()) System.out.println(fileNames);
		*/
		User temp = userDao.getUserById(1);
		System.out.println(temp.toString());
		userDao.updateUser(temp, temp.getU_fname(), "EE", temp.getU_email());
		temp = userDao.getUserById(1);
		System.out.println(temp.toString());
		for(ReimbursementTicket rt : rtDao.getReimbursementTickets()){
			System.out.println(rt.toString());
		}
		System.out.println("done");
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		Timestamp ts=new Timestamp(now.getTime());
		System.out.println(ts.toString());
		
		System.out.println("NEW TICKET");
		ReimbursementTicket rt = new ReimbursementTicket(213,"Test",null,2,1,1);
		rtDao.registerNewTicket(rt, null);
		
		for(ReimbursementTicket rts : rtDao.getReimbursementTickets()){
			System.out.println(rt.toString());
		}
		
	}

}