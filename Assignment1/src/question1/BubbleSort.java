package question1;

public class BubbleSort {

	 public BubbleSort() {
	}

	 // logic to sort the elements
	    public void bubble_srt(int array[]) {
	        int n = array.length;
	        int k;
	        for (int m = n; m >= 0; m--) {
	            for (int i = 0; i < n - 1; i++) {
	                k = i + 1;
	                if (array[i] > array[k]) {
	                    swapNumbers(i, k, array);
	                }
	            }
	            printNumbers(array);
	        }
	    }
	  
	    private static void swapNumbers(int i, int j, int[] array) {
	  
	        int temp;
	        temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	    }
	  
	    private static void printNumbers(int[] input) {
	          
	        for (int i = 0; i < input.length; i++) {
	            System.out.print(input[i] + ", ");
	        }
	        System.out.println("\n");
	    }
	    }
