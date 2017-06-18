package com.revature.q18;

public class SubClass extends SuperClass {

	public SubClass() {
		// TODO Auto-generated constructor stub
	}

	@Override
	//Check for uppercase characters in a string, and return ‘true’ or ‘false’ 
	//depending if any are found.
	public boolean hasUppercase(String s) {
		for(int i=0;i<s.length();i++){
			if(Character.isUpperCase(s.charAt(i)))
				return true;
		}
		return false;
	}

	@Override
	//Convert all of the lower case characters to uppercase in the input string,
	// and return the result. 
	public String lowercaseToUppercase(String s) {
		return s.toUpperCase();
	}

	@Override
	//Convert the input string to integer and add 10, output the result to the console.
	public void intStringToInt(String s) {
		int val = Integer.parseInt(s);
		System.out.println(val+10);
		
	}

}
