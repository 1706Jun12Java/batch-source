package com.revature.dogfactory;

public class Main {
	public static void main(String [] args) {
		Dog dog1 = DogFactory.getDog(DogFactory.POODLE);
		dog1.speak();
		
		Dog dog2 = DogFactory.getDog(DogFactory.ROTTWEILER);
		dog2.speak();
		
		Dog dog3 = DogFactory.getDog(DogFactory.SIBERIANHUSKY);
		dog3.speak();
	}
}
