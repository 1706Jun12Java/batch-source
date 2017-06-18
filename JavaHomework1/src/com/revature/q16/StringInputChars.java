package com.revature.q16;
/*
 * 
 * Q16. Write a program to display the number of characters for a string input. 
 * The string should be entered as a command line argument using (String [ ] args).
 */
public class StringInputChars {

	public static void main(String[] args) {
		System.out.println("\""+args[0]+"\"" + " has "+args[0].length()+" characters");
	}

}
