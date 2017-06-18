package Question9;

import java.util.*;

public class Question9 {

	public static void main(String[] args) {
		// Initialize ArrayList and assign values
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 1; i <= 100; i++)
			arr.add(i);
		// check each Integer for primes and print them
		for (Integer i : arr) {
			if (isPrime(i))
				System.out.println(i);
		}
	}

	/**
	 * returns true if the given number is prime
	 */
	public static boolean isPrime(int num) {
		// if no number from 2 to num/2 divides evenly
		// then its prime
		for (int n = 2; n <= num / 2; n++) {
			if (num % n == 0)
				return false;
		}
		// if this code is reached, the number is prime
		return true;
	}

}
