package question.twelve;

import java.util.Arrays;

public class EvenArray {

	public static void main(String[] args) {
		int[] mya = storeHundredNum(100);
		printEvenNum(mya);		

	}
	
	public static int[] storeHundredNum(int n){
		int[] myArray = new int[n];
		Arrays.setAll(myArray, i -> i + 1);
		return myArray;
	}
	
	public static void printEvenNum(int[] array){
		for (int i: array) {
			if (i%2==0) {
				System.out.println(i);
			}
			
		}
		
		
	}

}
