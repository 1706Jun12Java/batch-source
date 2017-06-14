package com.revature.exercise;

import java.util.Scanner;

public class Main {
	
	public static void converter(String a, String b, String c){
		a = a.toLowerCase();
		try{
			switch(a){
			case "byte":
				System.out.println(Byte.parseByte(b)+Byte.parseByte(c));
				break;
			case "int": 
				try{
					System.out.println(Integer.parseInt(b)+Integer.parseInt(c));
				}catch (Exception e){
					System.out.println();
				}
				break;
			case "float":
				System.out.println(Float.parseFloat(b)+Float.parseFloat(c));
				break;
			case "short":
				System.out.println(Short.parseShort(b)+Short.parseShort(c));
				break;
			case "long":
				System.out.println(Long.parseLong(b)+Long.parseLong(c));
				break;
			case "double":
				System.out.println(Double.parseDouble(b)+Double.parseDouble(c));
				break;
			}
		}
		catch (NumberFormatException e){
			System.out.println("Mehhh! Wrong input format.");
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter numeric data type and values separated by space: ");
		Scanner s = new Scanner(System.in);
		converter(s.next(), s.next(), s.next());
		s.close();
	}

}
