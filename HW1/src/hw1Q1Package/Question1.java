package hw1Q1Package;

//Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4

public class Question1 {
	
	public static void main(String[] args){
		
		//make a variable to store the numbers
		int[] intArray = {1,0,5,6,3,2,3,7,9,8,4};
		//Getting the length of the array
		int arrayLength = intArray.length;
		//some introduction
		System.out.println("The array before bubble sort:");
		for(int i = 0; i< arrayLength; i++){
			System.out.print(intArray[i] + " ");
		}
		//Bubble sort
		int temp; //temporary number storage for swapping
		for(int j= arrayLength; j > 1; j--){
			for(int i = 0; i < j-1; i++){
				if(intArray[i+1] < intArray[i]){
					temp = intArray[i+1];
					intArray[i+1] = intArray[i];
					intArray[i] = temp;
				}
			}
		}
		//displaying the result
		System.out.println("\nAfter bubble sort:");
		for(int i = 0; i< intArray.length; i++){
			System.out.print(intArray[i] + " ");
		}
	}
}

