package com.revature.q3;
/*
 * Q3. Reverse a string without using a temporary variable. 
 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 */
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Hello World";
		System.out.println(str);
		str=(reverseStr(str));
		System.out.println(str);
	}
	//adds chars to the string in reverse order
	//returns the added half of the string
	public static String reverseStr(String str){
		int len=str.length();
		for(int i=len;i>0;i--){
			str+=str.substring(i-1,i);
			
		}
		return (str.substring(len));
		
		
	}

}
