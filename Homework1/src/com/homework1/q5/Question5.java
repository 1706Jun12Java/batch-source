package com.homework1.q5;

public class Question5 {
	
	public static String subString(String s, int n){
		String temp = "";
		for(int i=0;i<n;i++){
			temp+= s.charAt(i);
		}
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(subString("someString", 5));
	}

}
