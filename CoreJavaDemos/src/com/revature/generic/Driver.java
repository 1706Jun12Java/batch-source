package com.revature.generic;

import java.util.LinkedList;
import java.util.List;

import com.revature.fruit.*;

public class Driver {

	public static void main(String[] args) {
		Fruit f = new Fruit();
		//Fruit anotherFruit = (Fruit) someMethod(f); ClassCastException
		Fruit anotherFruit  = someBetterMethod(f);
		Orange o = new Orange();
		Apple a = new Apple();
		List<Edible> snacks = new LinkedList<Edible>();
		snacks.add(f);
		snacks.add(a);
		snacks.add(o);
		System.out.println(howManySnacks(snacks));
	}
	
	public static Object someMethod(Object o){
		return new Integer(3);
	}
	
	public static <F> F someBetterMethod(F f){
		return f;
	}
	
	public static int howManySnacks(List<Edible> l){
		return l.size();
	}

}
