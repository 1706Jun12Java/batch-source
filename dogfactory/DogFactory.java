package com.revature.dogfactory;

public class DogFactory {
	public static final String POODLE = "poodle";
	public static final String ROTTWEILER = "rottweiler";
	public static final String SIBERIANHUSKY = "siberianhusky";
	public static Dog getDog(String nameOfDog) {
		if(nameOfDog == POODLE) {
			return new Poodle();
		}
		else if (nameOfDog == ROTTWEILER) {
			return new Rottweiler();
		}
		else if(nameOfDog == SIBERIANHUSKY) {
			return new Siberianhusky();
		}
		else {
			return null;
		}
	}

}
