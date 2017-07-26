package com.revature.service;

import org.springframework.stereotype.Component;

@Component(value = "tigerService")
public class TigerService extends AnimalService {

	private int tigerSpeed = 20;

	public int getSpeed() {
		return this.tigerSpeed;
	}

	private Boolean tigerFull = false;

	public Boolean getFull() {
		return tigerFull;
	}

	public void setFull(Boolean full) {
		this.tigerFull = full;
	}

	@Override
	public void wakeUpAnimal() {
		System.out.println("Woke up tiger.");

	}

	@Override
	public void animalChasesYou() {
		System.out.println("AAAAAHHHHHHHH!");
		System.out.println("Tiger is chasing you!");

	}

}
