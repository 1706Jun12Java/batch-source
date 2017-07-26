package com.revature.service;

import org.springframework.stereotype.Component;

@Component(value = "animalService")
public abstract class AnimalService {
	
	public abstract int getSpeed();

	public abstract void setFull(Boolean full);

	public abstract Boolean getFull();

	public abstract void wakeUpAnimal();

	public abstract void animalChasesYou();

	public void animalCatchesYou() {
		System.out.println("Hope he's not hungry.");
	}

}
