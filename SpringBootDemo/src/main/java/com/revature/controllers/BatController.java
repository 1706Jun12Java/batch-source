package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Bat;
import com.revature.service.BatService;

@RestController
@RequestMapping(value="/bat")
public class BatController {

	private BatService batService;
	
	@Autowired
	public BatController(BatService batService){
		this.batService = batService;
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Iterable<Bat> getAllBats(){
		return this.batService.getAllBats();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Bat getBatById(@PathVariable("id") int id){
		return this.batService.getBat(id);
	}
	
	

}
