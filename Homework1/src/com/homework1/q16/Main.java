package com.homework1.q16;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k = 0;
		for(String i: args){
			k+=i.length();
		}
		System.out.println(k+args.length-1);			
	}

}
