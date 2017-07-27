package com.revature.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Person;

@Controller
@RequestMapping("/person")
public class PersonController {

	@RequestMapping(value="/{firstName}/{lastName}",method=RequestMethod.GET)
	public String getPerson(@PathVariable String firstName, @PathVariable String lastName, Model m){
		//could (and probably should) be calling other code here!!! 
		m.addAttribute("firstName",firstName);
		m.addAttribute("lastName",lastName);
		return "demoOne";
	}
	
	@RequestMapping(value="/addInfo",method=RequestMethod.GET)
	public String getPersonInfo(Model m){
		m.addAttribute("person",new Person());
		return "infoPage";
	}
	
	@RequestMapping(value="/addInfo",method=RequestMethod.POST)
	public String addPersonInfo(@Valid Person person, BindingResult br, Model m){
		if(br.hasErrors()){
			Object errors  = br.getAllErrors();
			m.addAttribute("errors",errors);
			return "infoPage";
		} else {
			m.addAttribute("firstName",person.getFirstName());
			m.addAttribute("lastName",person.getLastName());
			m.addAttribute("dateOfBirth",person.getDateOfBirth());
			return "infoPage";
		}
		
	}
}
