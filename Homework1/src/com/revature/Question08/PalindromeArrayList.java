package com.revature.Question08;

import java.util.ArrayList;
import java.util.List;

public class PalindromeArrayList {
	
	public static boolean isPalindrome(String temp){
		char[] word = temp.toCharArray();
	    int i = 0;
	    int n = word.length - 1;
	    while (n > i) {
	        if (word[i] != word[n]) {
	            return false;
	        }
	        i++;
	        n--;
	    }
	    return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> palindromeList = new ArrayList<String>();
		List<String> wordList = new ArrayList<String>();
		
		String[] list = {"karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"}; 
		
		for(String i: list){
			wordList.add(i);
		}
		System.out.println("Original List: ");
		
		for(String j:wordList){
			System.out.print(j + " ");
		}
		
		for(String x : wordList){
			if(isPalindrome(x))
			palindromeList.add(x);			
		}
		
		System.out.println("\n\nPalindrome List: ");
		
		for(String e:palindromeList){
			System.out.print(e + " ");
		}

	}

}
