package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Bat;
import com.revature.dao.BatRepository;

@Component
@Transactional
public class BatService {

	//Spring boot will autowire your dependencies 
	private BatRepository batRepository;
	
	@Autowired
	public BatService(BatRepository batRepository){
		this.batRepository = batRepository;
	}
	
	public Iterable<Bat> getAllBats(){
		return this.batRepository.findAll();
	}
	
	public Bat getBat(int i){
		Bat b = this.batRepository.findOne(i);
		return b;
	}
	
	public long getCount(){
		return this.batRepository.count();
	}
}
