package com.hib.main;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hib.domain.UserRoles;
import com.hib.domain.Users;
import com.hib.util.HibernateUtil;

public class Driver {
	
	public static void main(String[] args) {
		init();
	}
	
	static void init(){
		Session s = HibernateUtil.getSession();

		try {
			Transaction transaction = s.beginTransaction();
			
			UserRoles userRoles1 = new UserRoles(1,"EMPLOYEE");
			
			Users user1 = new Users("lap", "lap", "lap", "top", "laptop@gmail.com", userRoles1);
			
			s.save(user1);

			transaction.commit();
			s.close();
		} catch (Exception e) {
			s.close();
		}

	}
}
