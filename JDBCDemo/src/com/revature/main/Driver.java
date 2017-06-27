package com.revature.main;

import java.sql.Connection;
import java.sql.Date;

import com.revature.dao.*;
import com.revature.domain.*;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		/*Connection con;
		try {
			con = ConnectionUtil.getConnectionFromFile("connection.properties");
			System.out.println(con.toString());
		} catch (Exception e){
			e.printStackTrace();
		}*/
		
		/*
		CaveDao cd = new CaveDaoImpl();
		System.out.println(cd.getCaves().toString());
		System.out.println(cd.getCaveById(1).toString());
		
		BearTypeDao btd = new BearTypeDaoImpl();
		System.out.println(btd.getBearTypes().toString());
		System.out.println(btd.getBearTypeById(1).toString());
		
		BeehiveDao bhd = new BeehiveDaoImpl();
		System.out.println(bhd.getBeehives().toString());
		System.out.println(bhd.getBeehiveById(1).toString()); 
		System.out.println(bhd.updateBeehiveWeight(1, 50));
		

		BearDao bd = new BearDaoImpl();
		for(Bear b : bd.getBears()){
			System.out.println(b);
		}
		System.out.println(bd.getBearById(3));
		Bear b = new Bear("Jason",new Cave(1,"doesn't matter",4),new BearType(1,"doesn't matter either"),500,new Date(1992, 9, 5));
		System.out.println(bd.createBear(b)); 
		System.out.println(bd.feedBear(1,1,15));*/
		
		//try our other implementation
		BearDao bd = new BearDaoXmlImpl("src/Bears.xml");
		bd.getBears();
	}

}
