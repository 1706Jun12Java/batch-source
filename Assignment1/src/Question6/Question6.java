package Question6;

public class Question6 {
	public static void main(String args[]) {
		System.out.println(isEven(0));
	}

	/**
	 * returns true if a number is even
	 */
	public static boolean isEven(int num) {
		// this variable is flipped when added/subtracted
		boolean even = true;
		// check the sign
		if (num > 0) {
			// if positive, subtract until we hit 0
			for (int i = 0; i < num; i++) {
				if (even)
					even = false;
				else
					even = true;
			}
			return even;
		} else if (num < 0) {
			// if negative, add until we hit 0
			for (int i = num; i < 0; i++) {
				if (even)
					even = false;
				else
					even = true;
			}
			return even;
		}
		// if 0, return true
		return even;
	}
}
