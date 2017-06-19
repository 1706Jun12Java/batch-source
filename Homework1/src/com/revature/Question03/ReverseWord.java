package com.revature.Question03;

public class ReverseWord {
	public static void main(String[] args){
		
		reverseword("hello");
		
		
}
	

	public static void reverseword(String temp){
		System.out.println(temp);
		
		for(int i=temp.length()-1;i>=0;i--){
			System.out.print(temp.charAt(i));
		}
		
	}
	
}

