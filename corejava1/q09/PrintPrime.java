package corejava1.q09;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Leibniz Berihuete
 * This is the main class
 * QUESTION 9
 *  Create an ArrayList which stores numbers from 1 to 100 and 
 *  prints out all the prime numbers to the console.
 */
public class PrintPrime {
	public static void main(String [] args) {
		ArrayList<Integer> primeList = new ArrayList<>();
		
		// A PRIME NUMBER CANNOT BE DIVISIBLE by 2 with the exception of number 2
		// A PRIME NUMBER CANNOT BE DIVISIBLE by 3 with the exception of number 3
		// A PRIME NUMBER HAS TO BE GREATER THAN 1
		for(int i = 1; i < 100; i++) {
			if(i == 2 || i == 3 || (i > 1 && i % 2 !=0 && i != 3 && i % 3 != 0)) {
				primeList.add(i);
			}
		}
		
		System.out.println(primeList);
	}
}
