package corejava1.q12;
/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 12
 * 	Write a program to store numbers from 1 to 100 in an array. 
 * 	Print out all the even numbers from the array. Use the 
 * 	enhanced FOR loop for printing out the numbers.
 */
public class Main {
	public static void main(String [] args) {
		
		// Create array of 100 numbers
		int [] arrayOfNumbers = new int[100];
		
		// Initializing array...
		for(int i=1; i <= 100; i++){
			arrayOfNumbers[i-1] = i;
		}
		
		// Create Enhanced FOR loop, and print only even numbers
		for(int x : arrayOfNumbers) {
			if(x % 2 == 0) {
				System.out.println(x);
			}
		}
		
		
	}
}
