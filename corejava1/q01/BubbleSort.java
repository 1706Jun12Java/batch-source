package corejava1.q01;

/**
 * 
 * @author Leibniz Berihuete
 *
 */



public class BubbleSort {
	
	public static void sort(int [] array) {
		boolean sorted = false;
		while(!sorted) {
			sorted = true;
			for(int i = 1; i < array.length; i++) {
				if(array[i-1] > array[i]) {
					// SWAP
					int temp = array[i];
					array[i] = array[i-1];
					array[i-1] = temp;
					
					sorted = false;					
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
