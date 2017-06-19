package com.nima.q3;

public class Q3 {

	/*Q3. Reverse a string without using a temporary variable.  
	Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.*/
	
	 public static void main(String[] args){
	        
	        String str="This is a test string"; //string to be reversed!
	        String reversed = "";
	        //loop to revers the string
	        for(int i=str.length()-1;i>=0;i--){
	            reversed += str.charAt(i);  //generating the reversed string
	        }
	        //printing the reversed string
	        System.out.println(reversed);
	    }
}
