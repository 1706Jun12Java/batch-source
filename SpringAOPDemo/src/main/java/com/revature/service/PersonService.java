package com.revature.service;

import org.springframework.stereotype.Component;

@Component(value="personService")
public class PersonService {
	
	private static int maxHumanSpeed = 10;

	public static int getSpeed(){
		return PersonService.maxHumanSpeed;
	}

}
