package com.revature.fruit;

public class Shadowing {

	public static void main(String[] args) {

		// instance variable x (instance scope)
		Apple a1 = new Apple();
		System.out.println(a1.x);

		// static variable y (static/class scope)
		// System.out.println(Apple.y);
		// System.out.println(a1.y);

		// instance method grow()
		a1.grow();

		// be careful about changing static members!
		/*
		 * Apple a2 = new Apple(); a2.x = 50;
		 * System.out.println("a2 has an x value of: "+a2.x); a2.y = 60;
		 * System.out.println("a2 has a y value of: "+a2.y);
		 * 
		 * System.out.println("a1 has an y value of: "+a1.y);
		 */

		// implicit upcast from Apple to Fruit
		Fruit f1 = a1;
		System.out.println(f1.x);
		// System.out.println(f1.y);
		f1.grow();

		Apple a3 = new Apple();
		System.out.println(a3.appleThing());
		Fruit f2 = new Fruit();
		// this throws a ClassCastException because f2 is not actually an Apple
		// (although it could be, from the compiler's perspective)
		//the compiler looks at the declared type 
		// ((Apple) f2).appleThing();
		
		a1.setColor("red");
		a1.setNumSeeds(4);
		a1.setName("apple 1");
		
		//play with varargs now
		countFruit(2, 2.5,a1,f1,a3,f2);
		countFruit(0,0.0);

	}

	// varargs example
	//the vararg must be the last parameter, one per method 
	static void countFruit(int a, Double b, Fruit... fruits) {
		System.out.println("printing fruits: ");
		for (Fruit f : fruits){
			System.out.println(f);
		}
	}

}
