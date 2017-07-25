package com.revature.beans;

public class BearWithConstructor extends Bear {

	private Cave c;

	public BearWithConstructor(Cave c) {
		this();
		this.c = c;
	}

	public BearWithConstructor() {
	}

	@Override
	public void methodInBear() {
		System.out.println("method in BearWithConstuctor");
		System.out.println(this.toString());
		System.out.println("cave: " + c.getName());
		System.out.println(c.toString());

	}

}
