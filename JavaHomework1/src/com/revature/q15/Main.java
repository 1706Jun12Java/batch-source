package com.revature.q15;
/*
 * Write a program that defines an interface having the following methods:
 *  addition, subtraction, multiplication, and division.  
 *  Create a class that implements this interface 
 *  and provides appropriate functionality to carry out the required operations. 
 *  Hard code two operands in a test class having a main method
 *   that calls the implementing class.

 * 
 */
public class Main {

	public static void main(String[] args) {
		SimpleCalculator calculator = new SimpleCalculator();
		System.out.println( calculator.addition(4,5));
		System.out.println( calculator.multiplication(4.2,5.7));
	}

}
