package com.revature.notCollections;

import java.util.Arrays;
import com.revature.fruit.*;

public class ArrayFun {

	public static void main(String[] args) {
		
		//ways to declare arrays
		int[] intArray1D = {5,6,7};
		int[] intArray1D2 = new int[7];
		int intArray1D3[] = new int[7]; //this is correct but horrible 
		
		//we're not limited to 1 dimension
		int[][] intArray2D = {{5},{7},{6,8}};
		int[][] intArray2D2 = new int[7][6];
		
		System.out.println(intArray1D.toString());
		
		//traversing arrays 
		for (int i=0;i<intArray2D.length;i++){
			for (int j=0;j<intArray2D[i].length;j++){
				System.out.print(intArray2D[i][j]+" ");
			}
			System.out.println();
		}
		
		//throws ArrayIndexOutOfBoundsException
		//System.out.println(intArray1D[3]);
		
		//utility class java.util.Arrays
		System.out.println(Arrays.toString(intArray2D));
		
		int[] powerBall = {38, 9, 2, 74, 0};
		System.out.println(Arrays.toString(powerBall));
		Arrays.sort(powerBall);
		System.out.println(Arrays.toString(powerBall));
		
		int index = Arrays.binarySearch(powerBall,2);
		System.out.println("the index of 2 in powerBall is: "+index);
		
		Apple a1 = new Apple("red",5);
		Apple a2 = new Apple("green",10);
		Orange o1 = new Orange("purple",8);
		Fruit[] fruitBowl = {a1,a2,o1};
		System.out.println(Arrays.toString(fruitBowl));
		 Arrays.sort(fruitBowl);
		System.out.println(Arrays.toString(fruitBowl));
	}

}
