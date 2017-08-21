package main;

public class Prime {

	public Prime() {
		// TODO Auto-generated constructor stub
	}

	public void checkPrime(int... num) {
		for (int n : num) {
			boolean prime = true;

			if (n < 2) {
				prime = false;
			}

			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					prime = false;
				}
			}

			if (prime) {
				System.out.print(n + " ");
			}

		}
		System.out.println(" ");
	}

}
