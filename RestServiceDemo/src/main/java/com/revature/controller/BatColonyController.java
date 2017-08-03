package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.domain.Bat;
import com.revature.domain.BatColony;
import com.revature.service.BatService;

@RestController
@RequestMapping(value="/colony")
public class BatColonyController {

	@Autowired
	BatService bs;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public @ResponseBody List<BatColony> getColonies(){
		return bs.getBatColonies();
	}

}
