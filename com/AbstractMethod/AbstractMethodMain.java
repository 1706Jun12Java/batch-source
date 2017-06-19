/*
 * Write a program having a concrete subclass that inherits three abstract methods
from a superclass. Provide the following three implementations in the subclass
corresponding to the abstract methods in the superclass:
1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending
if any are found.
2. Convert all of the lower case characters to uppercase in the input string, and
return the result.
3. Convert the input string to integer and add 10, output the result to the console.
Create an appropriate class having a main method to test the above setup.
 */
package com.AbstractMethod;

public class AbstractMethodMain {

	public static void main(String[] args) {
		
		AbstractMethod obj = new AbstractMethod();
		
		String str = "abcde";
		String number = "123";
		
		System.out.println(obj.checkString(str));
		System.out.println(obj.toUppercase(str));
		System.out.println(obj.toAdd(number));
	}
}

	