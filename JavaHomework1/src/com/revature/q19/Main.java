package com.revature.q19;

import java.util.*;

/*
 * Q19. Create an ArrayList and insert integers 1 through 10. 
 * Display the ArrayList. 
 * Add all the even numbers up and display the result.
 *  Add all the odd numbers up and display the result. 
 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 * 
 */
public class Main {

	public static void main(String[] args) {
		List<Integer> intValues = new ArrayList<>();
		for(int i=1;i<=10;i++)
			intValues.add(i);
	
	
		for(Integer intVal:intValues){
			System.out.print(intVal+" ");
		}
		System.out.println();
		int evenSum = 0,oddSum = 0;
		
		for(Integer intVal:intValues){
			if(intVal%2==0)
				evenSum+=intVal;
			else
				oddSum+=intVal;
		}

		System.out.println("The sum of all even numbers in the list is: "+evenSum);
		System.out.println("The sum of all odd numbers in the list is: "+oddSum);
		
			
		
	}
	//This function accepts an int value anf if that val is prime returns true
	public static boolean isPrime(int x){
		if(x==0||x==1){
			return false;
		}
		for(int i=2;i<x;i++){
			if(x%i == 0)
				return false;
		}
		return true;
	}
}
