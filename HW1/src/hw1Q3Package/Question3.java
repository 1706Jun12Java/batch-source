package hw1Q3Package;

//Reverse a string without using a temporary variable. 
//Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.

public class Question3 {
	public static void main(String[] args){
		//random string and print it
		String string = "Hello World";
		System.out.println(string);
		//for loop reversing the string 1 character at a time
		//done within the same string. Adding it after the original string
		//it will become 'Hello WorlddlroW olleH'
		for (int i = string.length()-1; i >= 0; --i) 
	        string += string.charAt(i);
		//Cut off the first half of the characters, leaving the reversed ones behind
		string = string.substring(string.length()/2);
		System.out.println("String after reverse:");
	    System.out.println(string);
	}
}
