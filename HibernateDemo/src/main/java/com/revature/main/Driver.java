package com.revature.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.dao.*;
import com.revature.domain.Bat;
import com.revature.domain.BatColony;
import com.revature.domain.BatType;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		//init();
		//bats();
		System.out.println(getById(3));

	}
	
	static Bat getById(int id){
		BatDao bd = new BatDaoImpl();
		return bd.getBatById(id);
	}
	
	static void bats() {
		
		BatDao bd = new BatDaoImpl();
		List<Bat> bats = bd.getBats();
		for(Bat b : bats){
			System.out.println(b);
		}
		
	}
	
	static void init() {
		
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		
		/*create transient objects*/
		
		BatType bt1 = new BatType("little brown bat");
		BatType bt2 = new BatType("fruit bat");
		BatType bt3 = new BatType("vampire");
		
		BatColony bc1 = new BatColony("Gotham");
		BatColony bc2 = new BatColony("Fire Nation");
		
		Bat b1 = new Bat("Bob",bt2,bc2);
		Bat b2 = new Bat("Bruce",bt1,bc2);
		Bat b3 = new Bat("Nosferatu",bt3,bc1);
		Bat b4 = new Bat("Barry",bt3,bc2);
		Bat b5 = new Bat("Barmander",bt2,bc1);
		
		System.out.println(s.save(bt1));
		System.out.println(s.save(bt2));
		System.out.println(s.save(bt3));
		
		System.out.println(s.save(bc1));
		System.out.println(s.save(bc2));
		
		System.out.println(s.save(b1));
		System.out.println(s.save(b2));
		System.out.println(s.save(b3));
		System.out.println(s.save(b4));
		System.out.println(s.save(b5));
		
		tx.commit();
		s.close();
	
	}

}
