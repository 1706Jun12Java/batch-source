package com.revature.fruit;

public class Orange extends Fruit{

	public Orange (String color, int numSeeds) {
		super(color,numSeeds,"orange");
	}
	
	public Orange (){
		super();
	}

	@Override
	public String toString() {
		return "Orange [x=" + x + "]";
	}

}
