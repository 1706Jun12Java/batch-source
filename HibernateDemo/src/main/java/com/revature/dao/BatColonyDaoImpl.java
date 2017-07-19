package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.domain.BatColony;
import com.revature.util.HibernateUtil;

public class BatColonyDaoImpl implements BatColonyDao {

	public BatColonyDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<BatColony> getBatColonies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BatColony getBatColonyById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int saveBatColony(BatColony b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(b);
		tx.commit();
		s.close();
		return result;
	}

}
