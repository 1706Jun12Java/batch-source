package corejava1.q19;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 19:
 *     Create an ArrayList and insert integers 1 through 10. 
 *     Display the ArrayList. Add all the even numbers up and 
 *     display the result. Add all the odd numbers up and display
 *     the result. Remove the prime numbers from the ArrayList
 *     and print out the remaining ArrayList.
 */
public class Main19 {
	public static void main(String [] args) {
		Integer [] arrayOfNums = {1,2,3,4,5,6,7,8,9,10};
		
		ArrayList<Integer> intList = new ArrayList<>(Arrays.asList(arrayOfNums));
		
		// Lets make another array just to hold prime numbers
		ArrayList<Integer> primeList = new ArrayList<>();
		
		int evenSum = 0;
		int oddSum = 0;
		
		// This for loop will do evenSum, oddSum, and primeList
		for(int i = 0; i < intList.size(); i++) {
			int num = intList.get(i);
			
			// Check if is even
			if(num % 2 == 0) {
				evenSum += num;
			}
			// else is odd
			else {
				oddSum += num;
			}
			
			// Check if is a prime num
			// A PRIME NUMBER CANNOT BE DIVISIBLE by 2 with the exception of number 2
			// A PRIME NUMBER CANNOT BE DIVISIBLE by 3 with the exception of number 3
			// A PRIME NUMBER HAS TO BE GREATER THAN 1
			if(i == 2 || i == 3 || (i > 1 && i % 2 !=0 && i != 3 && i % 3 != 0)) {
				primeList.add(i);
			}
		}
		
		// this for loop will remove the prime numbers from intList,
		// primeList will let intList know which one are the prime numbers
		// to remove.
		
		for(int i = 0; i < primeList.size(); i++) {
			int num = primeList.get(i);
			for(int x = 0; x < intList.size(); x++) {
				if(intList.get(x) == num) {
					intList.remove(x);
					break; // once found, break, no need to go further.
					
					/* **********************************
					 *  NOTE: double for-loop might not be the best answer,
					 *  new idea (maybe): instead of using an extra for loop
					 *  to find the number to remove, i could've use binary search,
					 *  since the numbers are already in order. 
					 * *********************************/
				}
			}
		}
		
		
		// Print evenSum
		System.out.println("Sum of even numbers: " + evenSum);
		
		// Print oddSum
		System.out.println("Sum of odd numbers: " + oddSum);
		
		// Print intList
		System.out.println("ArrayList without prime numbers: \n" + intList);
		
		
		
	}
}
