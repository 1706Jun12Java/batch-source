package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.BatColonyDao;
import com.revature.dao.BatDao;
import com.revature.dao.BatTypeDao;
import com.revature.domain.*;
import com.revature.protoDao.ProtoBatDao;

public class BatService {
	
	@Autowired
	BatDao batDao;
	//ProtoBatDao batDao;
	
	@Autowired
	BatTypeDao batTypeDao;
	
	@Autowired
	BatColonyDao batColonyDao;
	
	public List<Bat> getBats(){
		return batDao.findAll();
	}
	
	public Bat getBatByName(String name){
		return batDao.findBatByName(name);
	}
	
	public List<BatType> getBatTypes(){
		return batTypeDao.findAll();
	}
	
	public BatType addBatType(BatType batType){
		if (batTypeDao.save(batType) != null) {
			return batType;
		}else{
			return null;
		}
		
	}
	
	public List<BatColony> getBatColonies(){
		return batColonyDao.findAll();
	}

}
