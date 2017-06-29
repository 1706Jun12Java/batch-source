package com.revature.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.revature.domain.Bear;
import com.revature.domain.Cave;

public class BearDaoImpl implements BearDao {

	public BearDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Bear> getBears() {
		Cave c1 = new Cave(3,"Howe Caverns",5);
		Bear b1 = new Bear(1,"Yogi",c1,"Grizzly",500,new Date(4,7,1990));
		Bear b2 = new Bear(1,"Yoga",c1,"Grizzly",400,new Date(4,7,1990));
		List<Bear> bl = new ArrayList<Bear>();
		bl.add(b1);
		bl.add(b2);
		return bl;
	}

}
