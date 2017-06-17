package corejava1.q01;

/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 1:
 *    Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
 * 
 */
public class BubbleSort {
	
	public static void sort(int [] array) {
		
		// In order to know whether is sorted or not.
		boolean sorted = false;
		
		// while will continue until is fully sorted
		while(!sorted) {
			sorted = true; // Let's pretend is sorted
			
			for(int i = 1; i < array.length; i++) {
				if(array[i-1] > array[i]) {
					// SWAP
					int temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
					
					sorted = false; // Since a swap occured, it means that it wasn't sorted					
				}
			}
		}
	}
	
	public static void main(String [] args) {
		int [] array = {1,0,5,6,3,2,3,7,9,8,4};
		sort(array);
		
		for(int i: array) {
			System.out.print(i + ", ");
		}
	}
	
}
