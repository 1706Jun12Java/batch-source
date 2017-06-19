package q_2;

//Write a program to display the first 25 Fibonacci numbers beginning at 0.
public class Fibonacci {

	public static int fibonacci(int i) {

		if (i == 0)
			return 0;
		if (i <= 2)
			return 1;
		// formula used to calculate fibonacci of 'i' (once 'i' is greater than 2).
		int fibTerm = fibonacci(i - 1) + fibonacci(i - 2);
		return fibTerm;

	}

	public static void main(String[] args) {

		// runs 'i' number of times while printing 'i' and the fibonacci of 'i'
		for (int i = 0; i < 26; i++) {
			System.out.println("Fibonacci number " + i + " is: " + fibonacci(i));

		}
	}
}
