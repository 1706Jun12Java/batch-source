package q19;

import java.util.ArrayList;

//Create an ArrayList and insert integers 1 through 10.
//Display the ArrayList. Add all the even numbers up and 
//display the result. Add all the odd numbers up and display 
//the result. Remove the prime numbers from the ArrayList and print 
//out the remaining ArrayList.
public class Numbers {

	public static void main(String[] args) {

		ArrayList<Integer> num = new ArrayList<Integer>();
		int even = 0;
		int odd = 0;
		for (int i = 0; i < 11; i++) {
			if (i % 2 == 0) {
				even += i;
			} else {
				odd += i;
			}
			num.add(i);
			System.out.println(num.get(i));
		}
		System.out.println("\nAdding up all the even numbers gives us " + even);
		System.out.println("\nAdding up all the odds numbers gives us: " + odd);
		for (int i = 0; i < num.size(); i++) {
			if (isPrime(i)) {
				num.remove(i);
			}
			System.out.println(num.get(i));
		}
	}

	public static boolean isPrime(int n) {

		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}