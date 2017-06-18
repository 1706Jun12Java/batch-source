package Question1;

public class Question1 {

	public static void main(String[] args) {
		// create the array
		int arr[] = { 1, 0, 5, 6, 3, 2, 9, 3, 7, 9, 8, 4, 5, 8, 1, 3, 5, 4, 6, 0 };
		// call bubbleSort
		bubbleSort(arr);
		// show results
		for (int x = 0; x < arr.length; x++)
			System.out.println(arr[x]);
	}

	/**
	 * Sorts an Array using the BubbleSort Algorithm
	 * 
	 * @param intArr
	 *            The array being sorted
	 */
	public static void bubbleSort(int[] intArr) {
		// The starting value that will be compared to all other values
		for (int x = 0; x < intArr.length; x++) {
			// The value its being compared to
			// You'd think we'll start at 1
			for (int y = 0; y < intArr.length; y++) {
				// If the next value is greater, swap
				if (intArr[x] < intArr[y]) {
					int tmp;
					tmp = intArr[x];
					intArr[x] = intArr[y];
					intArr[y] = tmp;
				}
			}

		}
	}

}
