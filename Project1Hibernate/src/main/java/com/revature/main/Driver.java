package com.revature.main;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args){
		init();
	}
	static void init() {

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		/* create transient objects */
		UserRoles ur1 = new UserRoles("Employee");
		User u1 = new User("username","password","fname","lname","email",ur1);
		System.out.println(s.save(ur1));
		System.out.println(s.save(u1));
		
		tx.commit();
		s.close();

	}
}
