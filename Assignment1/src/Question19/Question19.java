package Question19;

import java.util.*;

public class Question19 {

	public static void main(String[] args) {
		// Intialize an ArrayList and assign values
		ArrayList<Integer> arr = new ArrayList();
		for (int i = 0; i < 10; i++) {
			arr.add(i);
		}
		// get the sum of all odd numbers
		int sum = 0;
		for (Integer n : arr) {
			if (n % 2 != 0)
				sum += n;
		}
		System.out.println("Sum of odd numbers is " + sum);
		// check all numbers for primes
		for (int n = 0; n < arr.size(); n++) {
			if (isPrime(n)) {
				// remove the prime
				arr.remove(arr.indexOf(n));
			}
		}
		System.out.println("Final ArrayList " + arr);
	}

	/**
	 * returns true if the given number is prime
	 * same as Question9
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
