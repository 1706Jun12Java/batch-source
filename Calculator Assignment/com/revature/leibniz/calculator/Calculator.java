package com.revature.leibniz.calculator;

import java.util.Scanner;
/**
 * 
 * @author Leibniz Berihuete
 * DATE: 06/14/2017
 * MAIN CLASS.  
 * CALCULATOR APP
 */
public class Calculator {
	// FINAL STRING DATA TYPE VALUES:
	private static final String SHORT = "short";
	private static final String BYTE = "byte";
	private static final String INT = "int";
	private static final String LONG = "long";
	private static final String FLOAT = "float";
	private static final String DOUBLE = "double";

	// FINAL CHAR OPERATOR VALUES:
	private static final char ADDITION = '+';
	private static final char SUBTRACTION = '-';
	private static final char MULTIPLICATION = '*';
	private static final char DIVISION = '/';

	public static void main(String [] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("+--------------------- INSTRUCTIONS -------------------+\n" +
						   "| (Only use the following data types & operators)      |\n" +
		                   "| DATA TYPES ARE: byte, short, int, long, float, double|\n" +
						   "| OPERATORS ARE: +, -, *, /                            |\n" +
		                   "+------------------------------------------------------+\n");
		
		// Prompt user for data type:
		System.out.print("ENTER DATA TYPE: ");		
		String dataTypeStr = keyboard.nextLine();
		
		// Prompt user for operator:
		System.out.print("ENTER OPERATOR:");
		char operator = keyboard.nextLine().charAt(0);
		
		Number firstValue = 0;
		Number secondValue = 0;
		
		switch(dataTypeStr.toLowerCase()) {
		case BYTE:
			// Prompt user for first byte value:
			System.out.print("ENTER FIRST VALUE: ");
			firstValue = Byte.parseByte(keyboard.nextLine());
			
			// Prompt user for second byte value:
			System.out.print("ENTER SECOND VALUE: ");
			secondValue = Byte.parseByte(keyboard.nextLine());			
			break;
			
		case SHORT:
			// Prompt user for first short value:
			System.out.print("ENTER FIRST VALUE: ");
			firstValue = Short.parseShort(keyboard.nextLine());
			
			// Prompt user for second short value:
			System.out.print("ENTER SECOND VALUE: ");
			secondValue = Short.parseShort(keyboard.nextLine());	
			break;
			
		case INT:
			// Prompt user for first int value:
			System.out.print("ENTER FIRST VALUE: ");
			firstValue = Integer.parseInt(keyboard.nextLine());
			
			// Prompt user for second int value:
			System.out.print("ENTER SECOND VALUE: ");
			secondValue = Integer.parseInt(keyboard.nextLine());	
			break;
			
		case LONG:
			// Prompt user for first long value:
			System.out.print("ENTER FIRST VALUE: ");
			firstValue = Long.parseLong(keyboard.nextLine());
			
			// Prompt user for second long value:
			System.out.print("ENTER SECOND VALUE: ");
			secondValue = Long.parseLong(keyboard.nextLine());	
			break;
			
		case FLOAT:
			// Prompt user for first float value:
			System.out.print("ENTER FIRST VALUE: ");
			firstValue = Float.parseFloat(keyboard.nextLine());
			
			// Prompt user for second float value:
			System.out.print("ENTER SECOND VALUE: ");
			secondValue = Float.parseFloat(keyboard.nextLine());	
			break;
			
		case DOUBLE:
			// Prompt user for first value:
			System.out.print("ENTER FIRST VALUE: ");
			firstValue = Double.parseDouble(keyboard.nextLine());
			
			// Prompt user for second value:
			System.out.print("ENTER SECOND VALUE: ");
			secondValue = Double.parseDouble(keyboard.nextLine());	
			break;
		default:
			System.out.println("ERROR: SOMETHING WRONG WITH THE DATA TYPE");
		}
		
		if(operator == ADDITION) {
			if(firstValue instanceof Byte) {
				byte result = (byte) (firstValue.byteValue() + secondValue.byteValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Short) {
				short result = (short) (firstValue.shortValue() + secondValue.shortValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Integer) {
				int result = (int) (firstValue.intValue() + secondValue.intValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Long) {
				long result = (long) (firstValue.longValue() + secondValue.longValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Float) {
				float result = (float) (firstValue.floatValue() + secondValue.floatValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Double) {
				double result = (double) (firstValue.doubleValue() + secondValue.doubleValue());
				System.out.println(result);
			}
			else {
				System.out.println("ERROR: SOMETHING WRONG WITH DATA TYPE");
			}
			
		}
		else if(operator == SUBTRACTION) {
			if(firstValue instanceof Byte) {
				byte result = (byte) (firstValue.byteValue() - secondValue.byteValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Short) {
				short result = (short) (firstValue.shortValue() - secondValue.shortValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Integer) {
				int result = (int) (firstValue.intValue() - secondValue.intValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Long) {
				long result = (long) (firstValue.longValue() - secondValue.longValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Float) {
				float result = (float) (firstValue.floatValue() - secondValue.floatValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Double) {
				double result = (double) (firstValue.doubleValue() - secondValue.doubleValue());
				System.out.println(result);
			}
			else {
				System.out.println("ERROR: SOMETHING WRONG WITH DATA TYPE");
			}
			
		}
		else if(operator == MULTIPLICATION) {
			if(firstValue instanceof Byte) {
				byte result = (byte) (firstValue.byteValue() * secondValue.byteValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Short) {
				short result = (short) (firstValue.shortValue() * secondValue.shortValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Integer) {
				int result = (int) (firstValue.intValue() * secondValue.intValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Long) {
				long result = (long) (firstValue.longValue() * secondValue.longValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Float) {
				float result = (float) (firstValue.floatValue() * secondValue.floatValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Double) {
				double result = (double) (firstValue.doubleValue() * secondValue.doubleValue());
				System.out.println(result);
			}
			else {
				System.out.println("ERROR: SOMETHING WRONG WITH DATA TYPE");
			}
			
		}
		else if(operator == DIVISION) {
			if(secondValue.doubleValue() == 0) {
				System.out.println("ERROR: CANNOT DIVIDE BY ZERO");
			}			
			else if(firstValue instanceof Byte) {
				byte result = (byte) (firstValue.byteValue() / secondValue.byteValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Short) {
				short result = (short) (firstValue.shortValue() / secondValue.shortValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Integer) {
				int result = (int) (firstValue.intValue() / secondValue.intValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Long) {
				long result = (long) (firstValue.longValue() / secondValue.longValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Float) {
				float result = (float) (firstValue.floatValue() / secondValue.floatValue());
				System.out.println(result);
			}
			else if(firstValue instanceof Double) {
				double result = (double) (firstValue.doubleValue() / secondValue.doubleValue());
				System.out.println(result);
			}
			else {
				System.out.println("ERROR: SOMETHING WRONG WITH DATA TYPE");
			}
			
		}
		else {
			System.out.println("ERROR: SOMETHING WRONG WITH THE OPERATOR");
		}
	}
}
