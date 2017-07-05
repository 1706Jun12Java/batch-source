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
		Cave c=new Cave(3,"Howe Carverns",5);
		List<Cave> cl=new ArrayList<>();
		cl.add(c);
		return cl;
	}

}
