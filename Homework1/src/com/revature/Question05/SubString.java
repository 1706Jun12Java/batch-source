package com.revature.Question05;

import java.util.Scanner;

public class SubString {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String: ");
		String string = sc.nextLine();
		System.out.println("Enter a number: ");
		int x = Integer.parseInt(sc.nextLine());
		subString(string,x);
		
	}
	
	static void subString(String temp, int x){
		char[] word = temp.toCharArray();
		
		for(int i=0; i<=x-1; i++){
			System.out.print(word[i]);
		}
	}

}
