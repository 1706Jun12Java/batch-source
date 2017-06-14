//USE java.util.Scanner
//- take a String specifying a numeric data type and two values
//- use wrapper class methods to convert values to numerics
//- add values and display result
//- push your code to your branch
//FOR 1:45 pm
//BONUS:
//	make a full calculator for any numeric type (+,-,*,/)

//Name:Bishwo Gurung
	
package com.revature.wrapperExercise;
import java.util.Scanner;

public class wrapperWork {

	public static void main(String[] args) {
		calc();
		
	}
	
	public static void calc(){
		System.out.println("Please enter an operator below.");
		Scanner op = new Scanner(System.in);
		String operator = op.nextLine();
		char oper = operator.charAt(0);
		
		System.out.println("Please enter the first value below.");
		Scanner first = new Scanner(System.in);
		String firstOperand = first.nextLine();
		
		System.out.println("Please enter the second value below.");
		Scanner second = new Scanner(System.in);
		String secondOperand = second.nextLine();		
				
		op.close();
		first.close();
		second.close();
		
		Float firstNum = Float.valueOf(firstOperand);
		Float secondNum = Float.valueOf(secondOperand);
		
		
		
		if (oper=='-'){
			Float result = firstNum-secondNum;
			System.out.println("The result is " + result + ".");
		}
		
		else if (oper=='+'){
			Float result = firstNum+secondNum;
			System.out.println("The result is " + result + ".");
		}
		
		else if (oper=='/'){
			Float result = firstNum/secondNum;
			System.out.println("The result is " + result + ".");
		}
		
		else if (oper=='*'){
			Float result = firstNum*secondNum;
			System.out.println("The result is " + result + ".");
		}
		else{
			System.out.println("Please a valid operator. (Hint: Use -,+,/, or *");
		}
		
		}
		
	}


