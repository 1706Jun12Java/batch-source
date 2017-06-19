package q12;

//Write a program to store numbers
//from 1 to 100 in an array. Print out
//all the even numbers from the array. Use the 
//enhanced FOR loop for printing out the numbers.
public class EvenNumbers {

	public static void main(String[] args) {

		int[] numbers = new int[100];
		for (int i = 0; i < 100; i++) {
			numbers[i] = i + 1;
			// System.out.println(array[i]);
		}
		for (int j : numbers) {
			if (j % 2 == 0) {
				System.out.println(j);
			}
		}
	}

}
