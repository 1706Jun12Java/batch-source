package Question2;

public class Question2 {

	public static void main(String[] args) {
		int num = 6;
		for (int x = 1; x <= num; x++)
			System.out.println(fibb(x));
	}

	/**
	 * find the fibbnacci result of a number
	 */
	public static int fibb(int num) {
		// return 1s and 0s to avoid infinite calls
		if (num == 0)
			return 0;
		if (num == 1)
			return 1;
		// call fibb again for lower values
		return fibb(num - 1) + fibb(num - 2);
	}

}
