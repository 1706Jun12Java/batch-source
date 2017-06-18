package Question12;

public class Question12 {

	public static void main(String[] args) {
		// Initialize array
		int[] arr = new int[100];
		// Assign values
		for (int x = 1; x <= 100; x++) {
			arr[x - 1] = x;
		}
		// Print only the even numbers
		for (int i : arr)
			if (i % 2 == 0)
				System.out.println(i);
	}

}
