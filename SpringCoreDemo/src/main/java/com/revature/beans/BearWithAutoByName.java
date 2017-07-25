package com.revature.beans;

public class BearWithAutoByName extends Bear {

	//the name of this property and its corresponding setter method 
	//MUST match the name of the bean to be injected as defined in the beans.xml 
	//or other metadata
	private Cave cave;

	public void setCave(Cave cave) {
		this.cave = cave;
	}

	public void methodInBear() {
		System.out.println("method in "+this.getClass().getSimpleName()); //we could generalize further
		System.out.println(this.toString());
		System.out.println("cave: " + cave.getName());
		System.out.println(cave.toString());
	}
	
	public void defaultDestroy(){
		System.out.println("default destroy from bearWithAutoByName");
	}
	
	public void defaultInit(){
		System.out.println("default init from bearWithAutoByName");
	}
	

}
