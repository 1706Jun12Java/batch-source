package q_1;

//Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
public class BubbleSort {

	// array of numbers to be sorted
	public static int[] numbers = new int[] { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };

	// method to perform Bubble Sort on the array of numbers.
	public static void bubbleSort() {

		int lastSwap;
		int lastCell = numbers.length - 1;
		int temp;

		System.out.println();
		System.out.println();
		System.out.println("Beginning of Bubble Sort");
		System.out.println();
		do {
			lastSwap = 0;
			System.out.println("lastCell = " + lastCell);

			for (int i = 0; i < lastCell; i++) {

				System.out.println("Comparing " + numbers[i] + " and " + numbers[i + 1]);
				if (numbers[i] > numbers[i + 1]) {
					System.out.println("Swapping " + numbers[i] + " and " + numbers[i + 1]);
					temp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = temp;
					lastSwap = i;
				}
				showNumbers();
			}

			System.out.println("lastSwap = " + lastSwap);
			lastCell = lastSwap;
		} while (lastCell > 0);

		System.out.println();
		System.out.println();
		System.out.println("End of Bubble Sort");
		System.out.println();
	}

	// method to print out the array of numbers
	public static void showNumbers() {
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println();
		System.out.println();
	}

	public static void main(String[] args) {

		bubbleSort();
	}
}
