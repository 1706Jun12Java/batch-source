package com.revature.q2;
/*
 * Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0. 
 */
public class Fibonacci {

	public static void main(String[] args) {
		for(int i=0;i<25;i++){
			System.out.println(fib(i));
		}

	}
	//returns the nth value in the fibonacci sequence
	public static int fib(int n){
		if(n==0){
			return 0;
		}
		else if(n==1){
			return 1;
		}
		
		return fib(n-1)+fib(n-2);
		
	}
	
	

}
