package com.revature.beans;

public class BearWithAutoByType extends Bear {

	private Cave c;

	public void setC(Cave c) {
		this.c = c;
	}

	public void methodInBear() {
		System.out.println("method in BearWithAutoByType");
		System.out.println(this.toString());
		System.out.println("cave: " + c.getName());
		System.out.println(c.toString());
	}

}
