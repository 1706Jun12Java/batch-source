package com.homework1.q6;

public class Question6 {
	public static boolean isEven(int n){
		n = java.lang.Math.abs(n);
		while(n>=0){
			if(n==0){
				return true;
			}
			if(n-2==0){
				return true;
			}
			else{
				n-=2;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isEven(6));
		System.out.println(isEven(0));
		System.out.println(isEven(-2));
		System.out.println(isEven(-1));
		System.out.println(isEven(5));
	}
}
