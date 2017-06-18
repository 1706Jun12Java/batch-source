package com.revature.q18;
/*
 * 
 * Write a program having a concrete subclass that 
 * inherits three abstract methods from a superclass.  
 * Provide the following three implementations in the subclass 
 * corresponding to the abstract methods in the superclass: 
 
Check for uppercase characters in a string, and return ‘true’ or ‘false’ 
depending if any are found.

Convert all of the lower case characters to uppercase in the input string,
 and return the result. 
 
Convert the input string to integer and add 10, output the result to the console.
Create an appropriate class having a main method to test the above setup.

 * 
 * 
 */
public class Main {

	public static void main(String[] args) {
		SuperClass test = new SubClass();
		String inputString = "does This class Have an uppercase?";
		
		System.out.println(test.hasUppercase(inputString));
		
		System.out.println(test.lowercaseToUppercase(inputString));
		
		test.intStringToInt("5");
		

	}

}
