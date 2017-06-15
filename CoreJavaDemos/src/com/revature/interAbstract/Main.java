package com.revature.interAbstract;

public class Main {

	public static void main(String[] args) {
		Shape s = new Square(5);
		int area = s.calculateArea();
		System.out.println(area);
	}

}
