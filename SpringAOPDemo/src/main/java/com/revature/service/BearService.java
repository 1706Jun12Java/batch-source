package com.revature.service;

import org.springframework.stereotype.Component;

@Component(value = "bearService")
public class BearService extends AnimalService {
	
	private int bearSpeed = 9;
	
	public int getSpeed(){
		return this.bearSpeed;
	}

	private Boolean bearFull = true; // bears eat before they hibernate

	public Boolean getFull() {
		return bearFull;
	}

	public void setFull(Boolean full) {
		this.bearFull = full;
	}
	
	public void bearHibernates(){
		System.out.println("ZZZZZZZZZZZZZZZZZZZZZ");
	}

	@Override
	public void wakeUpAnimal() {
		System.out.println("Woke up the bear.");
	}

	@Override
	public void animalChasesYou() {
		System.out.println("AAAAAHHHHHHHH!");
		System.out.println("Bear is chasing you!");
		
	}

	
}
