package com.revature.fruit;

public class Apple extends Fruit{
	
	int x = 30;
	static int y = 40;
	
	public void grow(){
		System.out.println("growing apple");
	}
	
	public Apple (String color, int numSeeds) {
		super(color,numSeeds,"apple");
	}
	
	public Apple (){
		super();
	}
	
	public String appleThing(){
		return "doing apple thing";
	}

	@Override
	public String toString() {
		return "Apple [x=" + x + "]";
	}

}
