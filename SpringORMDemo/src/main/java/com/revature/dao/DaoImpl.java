package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Cave;

@Transactional
public class DaoImpl implements Dao {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Cave> getCaves() {
		Session s = sessionFactory.getCurrentSession();
		List<Cave> caves = new ArrayList<Cave>();
		caves = s.createQuery("from Cave").list();
		return caves;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void makeCave(Cave cave) {
		Session s = sessionFactory.getCurrentSession();
		s.saveOrUpdate(cave);
	}

}
