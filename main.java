package classwork1;

import java.util.Scanner;

public class main {

	public static void main (String[] args) {
		calculator1();
	}
	public static void calculator1() {
		//Math Operator 
		System.out.println("Enter an mathematical operator and press enter:");
		Scanner s = new Scanner(System.in);
		String opera1 = s.nextLine();
		char operation1 = opera1.charAt(0);
		//First number
		System.out.println("Enter the first number and press enter:");
		Scanner first = new Scanner(System.in);
		String firstOperand = first.nextLine();
		//Second number 
		System.out.println("Enter the second number and press enter:");
		Scanner second = new Scanner(System.in);
		String secondOperand = second.nextLine();				
		s.close();
		first.close();
		second.close();
		Float num1 = Float.valueOf(firstOperand);
		Float num2 = Float.valueOf(secondOperand);
		if (operation1=='-'){
			Float ans1 = num1-num2;
		System.out.println("The answer is " + ans1);
		}
		else if (operation1=='+'){
			Float ans1 = num1+num2;
		System.out.println("The answer is " + ans1);
		}
		else if (operation1=='/'){
			Float ans1 = num1/num2;
		System.out.println("The answer is " + ans1);
		}
		else if (operation1=='*'){
			Float ans1 = num1*num2;
		System.out.println("The answer is: " + ans1);
		}
		else{
			System.out.println("Invalid operator.");
		} }
		
	

	}

