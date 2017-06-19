package com.revature.Question13;

public class triangleLoop {

	static boolean counter = true;

	public static void main(String[] args) {

		int size = 4;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (j <= i)
					toggle();
			}
			System.out.println("");
		}
	}

	static void toggle() {
		if (counter) {
			System.out.print("0");
			counter = false;
		} else {
			System.out.print("1");
			counter = true;
		}
	}
}
