package com.homework1.q14;

import java.util.Date;

public class Question14 {
	public static void main(String[] args) {
		int num = 1;
		switch(num){
		case 1:
			System.out.println(Math.sqrt(num));
			break;
		case 2:
			Date today = new Date();
			System.out.println(today);
			break;
		case 3:
			String s = "I am learning Core Java";
			String[] l = s.split(" ");
			System.out.println(l);
			break;
		}
	}
}
