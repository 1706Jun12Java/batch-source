package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.domain.BatColony;
import com.revature.domain.BatType;
import com.revature.service.BatService;

@RestController
@RequestMapping(value="/type")
public class BatTypeController {

	@Autowired
	BatService bs;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public @ResponseBody List<BatType> getTypes(){
		return bs.getBatTypes();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody String createBatType(@RequestBody BatType batType){
		if (bs.addBatType(batType)!= null){
			return "BatType created!";
		}else {
			return "BatType not created.";
		}
	}
	
	

}