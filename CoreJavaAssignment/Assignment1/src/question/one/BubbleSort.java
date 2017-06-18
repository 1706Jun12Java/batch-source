package question.one;
import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args){
		int[] myArray = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("myArray (before BubbleSort): " + Arrays.toString(myArray));
		sort(myArray);
		System.out.println("myArray (after BubbleSort): " + Arrays.toString(myArray));		
	}
	
	public static void sort(int[] arr){	
		int n = arr.length;
		boolean notSwapped = false;
		while(!notSwapped){
			notSwapped = true;
			for(int i=0; i<n-1; i++){
				if(arr[i]>arr[i+1]){
					swap(arr, i, i+1);
					notSwapped = false;
					
				}
				
			}
			
		}
		
	}
	
	public static void swap(int[] array, int i, int j){
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

}
