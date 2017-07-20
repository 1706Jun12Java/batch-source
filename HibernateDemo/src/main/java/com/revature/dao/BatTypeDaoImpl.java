package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.BatType;
import com.revature.util.HibernateUtil;

public class BatTypeDaoImpl implements BatTypeDao {

	public BatTypeDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BatType> getBatTypes() {
		List<BatType> types = new ArrayList<BatType>();
		Session s = HibernateUtil.getSession();
		types = s.createQuery("from BatType").list();
		return types;
	}

	@Override
	public BatType getBatTypeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveBatType(BatType b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(b);
		tx.commit();
		s.close();
		return result;
		// this still works non-transactionally!
	}

	public void persistBatType(BatType b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.persist(b);
		tx.commit();
		s.close();
	}

	@Override
	public BatType updateBatType(BatType b, String newName) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
			//s.save(b);
			b.setName(newName);
			s.saveOrUpdate(b);
		tx.commit();
		s.close();
		return null;
	}

	@Override
	public BatType mergeBatType(BatType b,String newName) {
		System.out.println(b);
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		//b.setName(newName);
		BatType bt2 = (BatType) s.merge(b);
		System.out.println(bt2);
		tx.commit();
		s.close();
		return null;
	}

}
