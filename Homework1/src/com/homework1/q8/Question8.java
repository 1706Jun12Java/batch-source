package com.homework1.q8;

import java.util.ArrayList;

public class Question8 {
	public static boolean isPalindrome(String s){
		for(int i=0; i<s.length()/2; i++){
			if(s.charAt(i)!=s.charAt(s.length()-1-i)){
				return false;	
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"karan", "madam","tom",
				"civic", "radar","jimmy","kayak","john","refer",
				"bily", "did"};
		ArrayList<String> stringArrayList = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>(); 
		
		for(String i: words){
			stringArrayList.add(i);
			if(isPalindrome(i)){
				palindromes.add(i);
			}
		}
		
		System.out.println(stringArrayList);
		System.out.println(palindromes);
	}

}
