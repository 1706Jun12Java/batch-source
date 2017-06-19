package q_9;

import java.util.ArrayList;

//Create an ArrayList which stores numbers 
//from 1 to 100 and prints out all the prime
//numbers to the console.
public class PrimeNumbers {

	public static void main(String[] args) {

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i < 101; i++) {
			numbers.add(i);
		}
/*
		System.out.println("List of numbers 1 - 100");
		for (int i = 0; i < numbers.size(); i++) {
			System.out.println(numbers.get(i));
		}
*/
		System.out.println("List of Prime numbers from 1-100");
		for (int i = 0; i < numbers.size(); i++) {
			if (i == 1) {
				System.out.println(2);
				i++;
			}
			if (isPrime(i)) {
				System.out.println(i);
			} else {
				continue;
			}
		}
	}

	// checks whether an int is prime or not.
	static boolean isPrime(int n) {
		// check if n is a multiple of 2
		if (n % 2 == 0)
			return false;
		// if not, then just check the odds
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
