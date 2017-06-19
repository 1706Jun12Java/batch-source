package com.nima.q8;

import java.util.ArrayList;

public class Q8 {
	
	/*
	 * Q8. Write a program that stores the following strings in 
	 * an ArrayList and saves all the palindromes in another ArrayList. 
	 */
	
	 public static void main(String[] args){
	        //first array lists to store values into it
	        ArrayList<String> list1 = new ArrayList<String>();
	        //adding values to it
	        list1.add("karan");
	        list1.add("madam");
	        list1.add("tom");
	        list1.add("civic");
	        list1.add("radar");
	        list1.add("jimmy");
	        list1.add("kayak");
	        list1.add("john");
	        list1.add("refer");
	        list1.add("billy");
	        list1.add("did");
	        //seconf array list to store pallindromes
	        ArrayList<String> list2 = new ArrayList<String>();
	        //addng pallindromes to second list
	        for (int i = 0; i < list1.size(); i++) {
	            if(isPalindrome(list1.get(i))){ //if its a pallindome, add it to list
	                list2.add(list1.get(i));
	            }
	        }
	        System.out.println("PALLINDROMES\n");
	        for (int i = 0; i < list2.size(); i++) {
	            System.out.println(list2.get(i));
	        }
	    }
	    //method to check pallindromes
	    public static boolean isPalindrome(String str) {
	        //loop to check if the string is pallindrome
	        for( int i = 0; i < str.length()/2; i++ )
	            if (str.charAt(i) != str.charAt(str.length()-i-1)){
	                return false;   //return false, if it doesn't
	            }
	        return true;        //return true, if it does.
	}
	

}
