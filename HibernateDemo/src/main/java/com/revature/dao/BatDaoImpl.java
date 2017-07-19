package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;

import com.revature.domain.Bat;
import com.revature.util.HibernateUtil;

public class BatDaoImpl implements BatDao {

	public BatDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Bat> getBats() {
		List<Bat> bats = new ArrayList<Bat>();
		Session s = HibernateUtil.getSession();
		bats = s.createQuery("from Bat").list();
		return bats;
	}

	@Override
	public Bat getBatById(int id) {
		Session s = HibernateUtil.getSession();
		Bat b = (Bat) s.get(Bat.class, id); //think: what would s.load do here? 
		s.close();
		return b;
	}

	@Override
	public int saveBat(Bat b) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int result = (int) s.save(b);
		tx.commit();
		s.close();
		return result;
	}

}
