package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Cave;

public class CaveDaoImpl implements CaveDao {

	public CaveDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Cave> getCaves() {
		System.out.println("called");
		Cave c = new Cave (3,"Howe Caverns",5);
		Cave c2 = new Cave (4,"Cave4",5);
		List<Cave> cl = new ArrayList<Cave>();
		cl.add(c);
		cl.add(c2);
		return cl;
	}

}
