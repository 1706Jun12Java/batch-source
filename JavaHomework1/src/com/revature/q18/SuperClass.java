package com.revature.q18;

public abstract class SuperClass {
	public SuperClass(){
		super();
	}
	//Check for uppercase characters in a string, and return ‘true’ or ‘false’ 
	//depending if any are found.
	public abstract boolean hasUppercase(String s);
	
	//Convert all of the lower case characters to uppercase in the input string,
	// and return the result. 
	public abstract String lowercaseToUppercase(String s);
	
	//Convert the input string to integer and add 10, output the result to the console.
	public abstract void intStringToInt(String s);
}
