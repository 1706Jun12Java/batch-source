package Question4;

public class Question4 {

	public static void main(String[] args) {
		System.out.print(fact(5));
	}

	/**
	 * returns the factorial of a number
	 */
	public static long fact(int n) {
		if (n == 1)
			return 1;
		return fact(n - 1) * n;
	}

}
