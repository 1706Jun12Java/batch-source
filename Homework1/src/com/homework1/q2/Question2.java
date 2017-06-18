package com.homework1.q2;

import java.util.ArrayList;

public class Question2 {
	public static ArrayList<Integer> fib(int n){
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(1);
		for(int i=2;i<n;i++){
			l.add(l.get(i-1)+l.get(i-2));
		}
		return l;
	}
	
	public static void main(String[] args) {
		int num = 25;
		for(int j: fib(num)){
			System.out.print(j+" ");
		}
	}
}
