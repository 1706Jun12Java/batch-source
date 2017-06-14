package com.revature.Calculator;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		System.out.println("Enter 2 numbers to add and their data type: ");
		System.out.println("Example: 2 5 integer || 20 93 double");
		Scanner sc = new Scanner(System.in);
		String command = sc.nextLine();
		while(command.equals("")){
			System.out.println("Nothing was entered. Please insert 2 numbers and a datatype: ");
			command = sc.nextLine();
		}
		String[] test = command.split(" ");
		while(test.length!=3){
			System.out.println("Must only use 3 arguments! Like: 3.0f 4.0f float ");
			command = sc.nextLine();
			test = command.split(" ");
		}
		
		
		switch (test[2]){
		case "integer":
			Number num1=Integer.parseInt(test[0]);
			Number num2=Integer.parseInt(test[1]);
			System.out.println((Integer)add(num1,num2));
			break;
		case "double":
			num1= Double.parseDouble(test[0]);
			num2= Double.parseDouble(test[1]);
			System.out.println(doubleadd(num1,num2));
			break;
		case "float":
			num1= Float.parseFloat(test[0]);
			num2= Float.parseFloat(test[1]);
			System.out.println(floatadd(num1,num2));
			break;
		default:
			System.out.println("Unrecognizable data type entered: " + test[2]);
			break;
		}	
	}

	private static Number add(Number num1, Number num2) {
		// TODO Auto-generated method stub
		return num1.intValue()+num2.intValue();
		
	}

	
	private static Number doubleadd(Number num1, Number num2) {
		// TODO Auto-generated method stub
		return (double)(num1.intValue()+num2.intValue());
		
	}
	
	private static Number floatadd(Number num1, Number num2) {
		// TODO Auto-generated method stub
		return (float)(num1.intValue()+num2.intValue());
		
	}
}
