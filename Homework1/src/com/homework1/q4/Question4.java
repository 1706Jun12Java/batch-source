package com.homework1.q4;

public class Question4 {
	
	public static int fac(int n){
		if(n==0){
			return 1;
		}
		return n*(fac(n-1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fac(1));
	}
	
}
