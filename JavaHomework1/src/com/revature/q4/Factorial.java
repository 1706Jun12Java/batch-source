package com.revature.q4;
/*
 * Q4. Write a program to compute N factorial.
 */
public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(factorialN(23));
	}
	public static int factorialN(int n){
		if(n==1)
			return 1;
		return n*factorialN(n-1);
	}

}
