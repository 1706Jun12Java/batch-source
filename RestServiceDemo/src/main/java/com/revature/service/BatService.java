package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.revature.domain.*;
import com.revature.protoDao.ProtoBatDao;

public class BatService {
	
	@Autowired
	ProtoBatDao batDao;
	
	public List<Bat> getBats(){
		return batDao.findAll();
	}

}
