package question1;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = new int[] { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		int[] array2 = new int [] { 1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4 };
		boolean flag = true; 
		int temp; 
		for(int a : array){
			System.out.print(a);
		}
		while (flag) {
			flag = false;
			for (int i= 0; i < array.length - 1; i++) {
				if (array[i] > array[i + 1])
				{
					temp = array[i]; 
					array[i] = array[i + 1];
					array[i + 1] = temp;
					flag = true; 
				}
			}
		}
		System.out.println("\nBubble sort using while loop");
		for(int a : array){
			System.out.print(a);
		}
		System.out.println("\nBubblesort using nested for loops");
		array2 = bubbleSort(array2);
		for(int a : array2){
			System.out.print(a);
		}
		
	}
	
	public static int[] bubbleSort(int[] array){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length;j++){
				if(array[j] > array[i]){
					int temp = array [i];
					array[i] = array [j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

}
