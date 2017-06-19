package com.revature.Question04;

import java.util.Scanner;

public class Factorial {
	public static void main(String[] args){
		System.out.println("Enter an integer to print out its Factorial: 3");
		Scanner sc = new Scanner(System.in);
		long x = sc.nextLong();
		
		System.out.println(x+"!= " + factorial(x));
		
		
	}

	private static long factorial(long x) {
		if(x==0)
			return 1;
		else 
			return x*factorial(x-1);
		
	}
}

