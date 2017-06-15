package com.revature.interAbstract;

public class Square extends Shape {
	
	public Square(int sideLength) {
		super();
		this.sideLength = sideLength;
	}
	
	public Square(){
		super();
	}



	private int sideLength;
	
	

	@Override
	public int calculateArea() {
		return sideLength*sideLength;
	}



	public int getSideLength() {
		return sideLength;
	}



	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

	@Override
	public void getMessage() {
	System.out.println("I'm a square! I have four sides!");
		
	}

}
