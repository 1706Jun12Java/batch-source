package com.revature.hello;

public class HelloWorld {
	
	public static void main(String[] args){
		System.out.println("Hello World");
		System.out.println(sumThing(3,4));
		HelloWorld hw = new HelloWorld();
		System.out.println(hw.sumThing2(4, 5));
		
		Batch b = new Batch();
		b.setGreeting("welcome to the batch");
		System.out.println(b.getGreeting());

	}
	
	//can use a static method without an instantiation of the class
	//static = affiliated with the class, not any particular object
	public static int sumThing(int a, int b){
		return a+b;
	}
	
	public int sumThing2(int c, int d){
		return c+d;
	}
	
	//overloaded sumThing2
	public Double sumThing2(Double c, Double d){
		return c+d;
	}

	@Override
	public String toString() {
		return "HelloWorld []";
	}
	

}
