package com.revature.dao;

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
		// TODO Auto-generated method stub
		return null;
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
	}

}
