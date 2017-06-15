package com.revature.controlFlow;

public class Main {

	public static void main(String[] args) {
		
		int i = 3;
		boxing(i);
		
		double d = java.lang.Math.PI;
		boxing(d);
		
		Integer i2 = new Integer(4);
		i2 = unboxing(i2);
		System.out.println(i2.toString());
		
		//logical operators and comparators: < > <= >= != ==
		//or: | or || (second is the short-circuit)
		//and: & or && ("" "") 
		
		//ternary operator
		int value1 = 1;
		int value2 = 2;
		int result;
		boolean someCondition = true;
		result  = someCondition ? value1 : value2;
		System.out.println(result);
		//if the condition is true, first value is printed
		//if false, second value is printed. 
		
		System.out.println(whatMonthIsIt(6));
		
		//pre- and post- iterators 
		int j = 1;
		System.out.println(j);
		int k = ++j;
		System.out.println("j is equal to: "+j);
		System.out.println("k is equal to: "+k);
		int l = j++;
		System.out.println("j is equal to: "+j);
		System.out.println("l is equal to: "+l);
		
		for (int m =0 ;m<10;m++)
		{
			if (m==3 ) {
				continue;
				//break would escape the loop
				//break;
			}
			System.out.println(m);
		}

		
	
	}
	
	public static void boxing(Number n){
		System.out.println(n.toString());
	}
	
	public static int unboxing(int i){
		System.out.println(i);
		return i;
	}
	
	public static String whatMonthIsIt(int month){
		String monthString = "";
		
		switch (month) {
		case 1: 
			monthString = "January";
			break;
		case 2:
			monthString = "February";
			break;
		case 3:
			monthString = "March";
			break;
		case 4:
			monthString = "April";
			break;
		case 5:
			monthString = "May";
			break;
		case 6:
			monthString = "June";
			break; //if we removed this, the result for month=6 would be July
		case 7:
			monthString = "July";
			break;
		case 8:
			monthString = "August";
			break;
		case 9:
			monthString = "September";
			break;
		case 10:
			monthString = "October";
			break;
		case 11:
			monthString = "November";
			break;
		case 12:
			monthString = "December";
			break;
		default:
			monthString = "Invalid month";
			break;
		}
		
		return monthString;
	}

}
