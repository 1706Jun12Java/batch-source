package com.revature.service;

import org.springframework.stereotype.Component;

@Component(value = "bearService")
public class BearService extends AnimalService {
	
	private Boolean isWinter = false;
	
	public void setIsWinter(Boolean isWinter){
		this.isWinter = isWinter;
	}
	
	public Boolean getIsWinter(){
		return this.isWinter;
	}
	
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
	
	public void bearHibernates() throws Exception{
		System.out.println("ZZZZZZZZZZZZZZZZZZZZZ");
		if(!this.isWinter){
			throw new Exception("bears hibernate in the winter!");
		}
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
