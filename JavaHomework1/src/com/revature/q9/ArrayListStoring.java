package com.revature.q9;

import java.util.ArrayList;
import java.util.List;

/*
 * Q9. Create an ArrayList which stores numbers from 1 to 100 
 * and prints out all the prime numbers to the console.
 */
public class ArrayListStoring {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		for(int i =1 ; i<=100;i++)
			numbers.add(i);
	
		for (Integer num : numbers) {
			if(isPrime(num)==true)
				System.out.println(num);
		}
	}
	
	//accepts an int value and returns true if it is a prime number
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
