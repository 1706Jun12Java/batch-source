package com.homework1.q3;

public class Question3 {
	
	public static String reverse(String s){
		if(s!=null && s.length()>0){
			return reverse(s.substring(1))+s.charAt(0);
		}
		return s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("xyz"));
	}

}
