package com.revature.mavenDemo;

public class StringCalculator {
	
	/*
	 * Requirement 1: create a String calculator with a method int add(String numbers)
	 * The method can take 0, 1, or 2 numbers
	 * Requirement 2: the method will return their sum. 
	 * Use comma as delimiter
	 * Requirement 3: returns 0 for empty string
	 * 
	 */
	
	public static void main(String[] args){
		
	}
	
	public static int add(String numbers){
		int sum = 0;
		String[] numbersArray = numbers.split(",");
		if (numbersArray.length > 2){
			throw new RuntimeException("too many numbers");
		} else {
			for (String number : numbersArray){
				if (!number.equals("")){
					sum += Integer.parseInt(number);
				} else {
					 continue; //allowed for consecutive commas 
				}
			}
		}
		return sum;
	}

}
