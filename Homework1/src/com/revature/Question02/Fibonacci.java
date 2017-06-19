package com.revature.Question02;
public class Fibonacci {
	
	public static void main(String[] args){
		System.out.println("25th term of Fibonacci sequence : " + fibonacci(25));
		for(int i=1; i<=25; i++){
			System.out.print(fibonacci(i) + " + ");
		}
		
	}
	
	public static long fibonacci(int n){
		if(n<=1)
			return n;
		else
			return fibonacci(n-1) + fibonacci(n-2);
	}

}

