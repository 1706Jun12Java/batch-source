package com.revature.q8;

import java.util.*;

/*
 * Q8. Write a program that stores the following strings in an ArrayList 
 * and saves all the palindromes in another ArrayList.
  “karan”, “madam”, ”tom”, “civic”, “radar”, “jimmy”, “kayak”, “john”,
  “refer”, “billy”, “did”

 */
public class SavePalindromes {

	public static void main(String[] args) {
		List<String> words = new ArrayList<>();
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");
		
		List<String> palindromeWords = new ArrayList<>();
		palindromeWords = savePalindromes(words);
		for (String word : palindromeWords) {
		    if(isPalindrome(word)==true)
		    	System.out.println(word);
		}
		
		

	}
	public static boolean isPalindrome(String s){
		if(s.length()==0)
			return true;
		if(s.length()==1)
			return true;
		if(s.substring(0, 1).equals(s.substring(s.length()-1)) == false)
			return false;
		else{
			//System.out.println(s.substring(1,s.length()-1));
			return isPalindrome(s.substring(1,s.length()-1));
		}
	}
	
	public static List<String> savePalindromes(List<String> words){
		List<String> pals = new ArrayList<>();
		for (String word : words) {
		    if(isPalindrome(word)==true)
		    	pals.add(word);
		}
		return (ArrayList<String>) pals;
	}
}
