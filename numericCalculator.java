package June6_14Exercise;

import java.util.Scanner;
public class numericCalculator {
	
	public static void main(String[] args){
		Double num1;
		Double num2;
		String operation;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first number:");
		
		num1 =input.nextDouble();
		System.out.print("Enter the operation (+ - * /):");
		operation = input.next();
		System.out.print("Enter the second number:");
		num2 = input.nextDouble();
		switch(operation){
		case "+":
			boxing(num1 + num2);
			break;
		case "-":
			boxing(num1 - num2);
			break;
		case "*":
			boxing(num1 * num2);
			break;
		case "/":
			boxing(num1 / num2);
			break;
		default:
			System.out.println("Wrong input, please start over.");
		}
	}
	
	public static void boxing(Number n){
		System.out.println(n);
	}
	
}

