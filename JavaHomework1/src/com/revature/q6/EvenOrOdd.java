package com.revature.q6;
/*
 * Write a program to determine if an integer is even without using the modulus operator (%)
 */
public class EvenOrOdd {

	public static void main(String[] args) {
		evenOrOdd(5);
		evenOrOdd(50);
		evenOrOdd(52);
		evenOrOdd(15);

	}
	public static void evenOrOdd(int value){
		int val = value;
		while(val>1){
			val-=2;
		}
		if(val == 1)
			System.out.println(value + " is an odd number");
		else
			System.out.println(value + " is an even number");
	}

}
