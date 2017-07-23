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
			UserRoles userRoles2 = new UserRoles(2,"MANAGER");
//			
//			s.save(userRoles1);
//			s.save(userRoles2);
			
			Users user1 = new Users("bob1", "bob1", "bob1", "thebuilder1", "bob1thebuilder1@gmail.com", userRoles1);
			Users user2 = new Users("11", "11", "first1", "last1", "first1last1@gmail.com", userRoles2);
			
			s.save(user1);
			s.save(user2);

			transaction.commit();
			s.close();
		} catch (Exception e) {
			s.close();
		}

	}
}
