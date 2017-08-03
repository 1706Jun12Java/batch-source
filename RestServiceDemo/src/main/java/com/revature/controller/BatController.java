package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.domain.Bat;
import com.revature.service.BatService;

@RestController 
@RequestMapping(value="/bat")
public class BatController {

	@Autowired
	BatService bs;
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public @ResponseBody List<Bat> getBats(){
		return bs.getBats();
	}
	
	@RequestMapping(value="/{name}",method=RequestMethod.GET)
	public ResponseEntity<Bat> getBatByName(@PathVariable("name") String name){
		return ResponseEntity.ok(bs.getBatByName(name));
	}
	

}
