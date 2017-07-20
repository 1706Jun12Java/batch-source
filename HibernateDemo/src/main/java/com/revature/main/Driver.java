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
import com.revature.domain.Bat;
import com.revature.domain.BatColony;
import com.revature.domain.BatType;
import com.revature.util.HibernateUtil;

public class Driver {

	public static void main(String[] args) {
		// init();
		// bats();
		// this throws a LazyInitializationException!
		// System.out.println(getById(3));
		// BatType bt = new BatType("bigger");
		// bt.setId();
		// mergeBatType(bt,"enormousest");
		// persistType(bt);
		// batTypes();
		// playWithCascades();
		// BatType bt = new BatType();
		// bt.setId(2);
		// execNamedQuery(bt);
		//funWithCriteria();
		cacheMeOutside();

	}
	
	static void cacheMeOutside(){
		Session s = HibernateUtil.getSession();
		
		List<Bat> batsWithBs = s.createCriteria(Bat.class).list();
		for (Bat b : batsWithBs) {
			System.out.println(b);
		}
		
		List<Bat> batsWithBs2 = s.createCriteria(Bat.class).add(Restrictions.like("name", "B%")).list();
		for (Bat b : batsWithBs2) {
			System.out.println(b);
		}
		
		
		
		
		s.close();
		
	}
	
	static void funWithCriteria() {
		Session s = HibernateUtil.getSession();

		List<Bat> batsWithBs = s.createCriteria(Bat.class).add(Restrictions.like("name", "B%")).list();
		for (Bat b : batsWithBs) {
			System.out.println(b);
		}

		List<Bat> mediumBats = s.createCriteria(Bat.class).add(Restrictions.between("wingspan", 50, 400))
				.addOrder(Order.asc("wingspan")).list();
		for (Bat b : mediumBats) {
			System.out.println(b);
		}
		
		Criteria cr = s.createCriteria(Bat.class);
		cr.setProjection(Projections.rowCount());
		List rowCount = cr.list();
		System.out.println("number of bats: "+rowCount.get(0));
		
		Criteria batCentimeters = s.createCriteria(Bat.class);
		batCentimeters.setProjection(Projections.sum("wingspan"));
		List totalBat = batCentimeters.list();
		System.out.println("total centimeters of bat wings: "+totalBat.get(0));
		
		s.close();
	}

	static void playWithCascades() {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		BatColony bc = (BatColony) s.get(BatColony.class, 1);
		System.out.println(bc);
		System.out.println(bc.getMembers());
		s.delete(bc);
		tx.commit();
		s.close();
	}

	static void execNamedQuery(BatType bt) {
		Session session = HibernateUtil.getSession();
		Query query = session.getNamedQuery("findBatByType");
		query.setInteger("typevar", bt.getId());
		List<Bat> bats = query.list();
		System.out.println(bats.size());
		Iterator<Bat> itr = bats.iterator();
		while (itr.hasNext()) {
			Bat b = itr.next();
			System.out.println(b);
		}
		session.close();
	}

	static void updateBatType(BatType bt, String newName) {
		BatTypeDao btd = new BatTypeDaoImpl();
		btd.updateBatType(bt, newName);
	}

	static void mergeBatType(BatType bt, String newName) {
		BatTypeDao btd = new BatTypeDaoImpl();
		btd.mergeBatType(bt, newName);
	}

	static int saveType(BatType bt) {
		BatTypeDao btd = new BatTypeDaoImpl();
		return btd.saveBatType(bt);
	}

	static void persistType(BatType bt) {
		BatTypeDao btd = new BatTypeDaoImpl();
		btd.persistBatType(bt);
	}

	static Bat getById(int id) {
		BatDao bd = new BatDaoImpl();
		return bd.getBatById(id);
	}

	static void batTypes() {

		BatTypeDao btd = new BatTypeDaoImpl();
		List<BatType> bats = btd.getBatTypes();
		for (BatType bt : bats) {
			System.out.println(bt);
		}

	}

	static void bats() {

		BatDao bd = new BatDaoImpl();
		List<Bat> bats = bd.getBats();
		for (Bat b : bats) {
			System.out.println(b);
		}

	}

	static void init() {

		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();

		/* create transient objects */

		BatType bt1 = new BatType("little brown bat");
		BatType bt2 = new BatType("fruit bat");
		BatType bt3 = new BatType("vampire");

		BatColony bc1 = new BatColony("Gotham");
		BatColony bc2 = new BatColony("Fire Nation");

		Bat b1 = new Bat("Bob", 100, bt2, bc2);
		Bat b2 = new Bat("Bruce", 20, bt1, bc2);
		Bat b3 = new Bat("Nosferatu", 350, bt3, bc1);
		Bat b4 = new Bat("Barry", 5, bt3, bc2);
		Bat b5 = new Bat("Barmander", 600, bt2, bc1);

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
