package hw1Q15;

import java.util.Scanner;

public class Question15 implements Q15Interface{


	public static void main(String[] args) {
		double num1;
		double num2;
		double result;
		String operator;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number:");
		num1 = input.nextDouble();
		System.out.println("Enter operator:");
		operator = input.next();
		System.out.println("Enter second number:");
		num2= input.nextDouble();
		if(operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")){
			switch(operator){
			case "+":
				result = addition(num1,num2);
				System.out.println(addition(num1,num2));
				break;
			case "-":
				result = addition(num1,num2);
				System.out.println(addition(num1,num2));
				break;
			case "*":
				result = addition(num1,num2);
				System.out.println(addition(num1,num2));
				break;
			case "/":
				result = addition(num1,num2);
				System.out.println(addition(num1,num2));
				break;
			default:
				break;
			}
		}else{
			System.out.println("Invalid operator");
		}
		
		
	}

	public static double addition(double num1, double num2) {
		return num1+num2;
	}

	public static double subtraction(double num1, double num2) {
		return num1-num2;
	}

	public static double multiplication(double num1, double num2) {
		return num1*num2;
	}

	public static double division(double num1, double num2) {
		return num1/num2;
	}



}
