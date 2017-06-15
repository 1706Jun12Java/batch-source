package com.revature.fruit;

public class PassByValue {

	public static void main(String[] args) {
		
		/*
		int number = 3;
		 printNext(number);
		 System.out.println("number inside main: "+number);
		 */
		Fruit f = new Fruit();
		f.setColor("green");
		System.out.println("color of fruit before changeColor: "+f.getColor());
		changeColor(f);
		System.out.println("color of fruit after changeColor: "+f.getColor());
	}
	
	public static void printNext(int number){
		number++;
		System.out.println("number inside printNext: "+number);
	}
	
	public static void changeColor(Fruit f){
		//f = new Fruit();
		f.setColor("blue");
		System.out.println("color of fruit inside changeColor: "+f.getColor());
		
	}

}
