package Question13;

public class Question13 {

	public static void main(String[] args) {
		// variable to check if we print 1 or 0
		boolean zero = true;
		// number of columns
		for (int x = 1; x <= 4; x++) {
			// number of rows
			for (int y = 0; y < x; y++) {
				// if zero, then print 0
				// otherwise, print 1
				if (zero) {
					System.out.print(0 + " ");
					zero = false;
				} else {
					System.out.print(1 + " ");
					zero = true;
				}
			}
			// create a new line
			System.out.println("");
		}
	}

}
