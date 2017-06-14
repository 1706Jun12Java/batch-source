package com.revature.wrapperAssignment;

import java.util.Scanner;
public class WrapperAssignment {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter numeric data type two values");
		System.out.println("For example: int 4 5");
		String lineRead=sc.nextLine();
		sc.close();
		//Number val,val2;
		int space1,space2;
		space1=lineRead.indexOf(" ");
		space2=lineRead.indexOf(" ",space1+1);
		//System.out.println(lineRead);
		Number val1=Double.parseDouble(lineRead.substring(space1+1,space2));
		//System.out.println(val1.doubleValue());
		
		Number val2=Double.parseDouble(lineRead.substring(space2+1));
		//System.out.println(val2.doubleValue());
		
		String type=lineRead.substring(0, space1);
		//System.out.println(type);
		Number result = add(val1,val2,type);
		printNum(val1,val2,result,type);
		
		

	}
	public static Number add(Number n1,Number n2,String type){
		switch (type){
		case "int":
			return (n1.intValue()+n2.intValue());
		case "double":
			return (n1.doubleValue()+n2.doubleValue());
			
		case "byte":
			return (n1.byteValue()+n2.byteValue());
			
		case "short":
			return(n1.shortValue()+n2.shortValue());
			
		case "long":
			return (n1.longValue()+n2.longValue());
			
		case "float":
			return (n1.floatValue()+n2.floatValue());
			
		default:
			return (n1.doubleValue()+n2.doubleValue());
		
		}
		
	}
	
	public static void printNum(Number n1,Number n2,Number result,String type){
		switch (type){
		case "int":
			System.out.println(n1.intValue()+" + "+ n2.intValue() + " = "+ result.intValue());
			break;
		case "double":
			System.out.println(n1.doubleValue()+" + " +n2.doubleValue() + " = " +result.doubleValue());
			break;
		case "byte":
			System.out.println(n1.byteValue()+" + " +n2.byteValue() + " = " +result.byteValue());
			break;
		case "short":
			System.out.println(n1.shortValue()+" + "+ n2.shortValue() + " = " +result.shortValue());
			break;
		case "long":
			System.out.println(n1.longValue()+" + "+ n2.longValue() + " = " +result.longValue());
			break;
		case "float":
			System.out.println(n1.floatValue()+" + "+ n2.floatValue() + " = "+ result.floatValue());
			break;
		default:
			System.out.println(n1.doubleValue()+" + "+ n2.doubleValue() + " = " +result.doubleValue());
			
		
		}
		
	}
	
	

}
