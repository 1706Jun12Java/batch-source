package com.revature.q5;
/*
 * Q5. Write a substring method that accepts a string str and an integer idx 
 * and returns the substring contained between 0 and idx-1 inclusive.  
 * Do NOT use any of the existing substring methods
 *  in the String, StringBuilder, or StringBuffer APIs.
 */
public class SubStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Hello test program for q5";
		String s2 = subString(s1, 5);
		System.out.println(s2);
	}

	public static String subString(String s, int index) {
		String temp = "";
		for (int i = 0; i < index; i++)
			temp += s.charAt(i);
		return temp;
	}

}
