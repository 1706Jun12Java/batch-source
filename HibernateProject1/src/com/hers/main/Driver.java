package com.hers.main;

import org.hibernate.Transaction;

import java.math.BigDecimal;

import org.hibernate.Session;

import com.hers.domain.UserModel;
import com.hers.domain.UserRoleModel;
import com.hers.util.HibernateUtil;

public class Driver {
	
	public static void main(String[] args) {
		doSomething();
		
	}
	
	static void doSomething(){
		Session s = HibernateUtil.getSession();
		
		try {
		Transaction tx = s.beginTransaction();
		
		UserRoleModel managerRole = new UserRoleModel("Manager");
		UserRoleModel employeeRole = new UserRoleModel("Employee");
		
		
//		UserModel uA = new UserModel("asdf", null, null, null, managerRole);
		s.save(managerRole);
		s.save(employeeRole);

		tx.commit();
		s.close();
		} catch (Exception e){
			s.close();
		}
		
	}

}
