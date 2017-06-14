package com.revature.calculator;
import java.util.*; 

public class Calculator {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu(){
		
		Scanner sc = new Scanner (System.in); 
		
		System.out.println("Enter 1st Number: ");
		Integer n1 = sc.nextInt(); 
		
		System.out.println("Enter 2nd Number: ");
		Integer n2 = sc.nextInt(); 

		int answer = 0; 
		
		System.out.println("Enter an operator (+,-*,/): ");
		String operator = sc.next().trim(); // trim removes white space from the input
			
		switch(operator){
		case "+": 
			answer = n1 + n2;
			System.out.println(answer);
			break;
		
		case "-":
			answer = n1 - n2;
			System.out.println(answer);
			break;
			
		case "*":
			answer = n1 * n2;
			System.out.println(answer);
			break;
			
		case "/":
			answer = n1 / n2;
			System.out.println(answer);
			break;
			
		default:
			System.out.println("Invalid input!");
			
		}
		
		
		
		
		sc.close();
			
	}

}
