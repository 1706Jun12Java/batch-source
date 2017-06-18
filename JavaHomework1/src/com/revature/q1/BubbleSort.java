package com.revature.q1;
/*
 * Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
 */
public class BubbleSort {

	public static void main(String[] args) {
		int[] arr={1,0,5,6,3,2,3,7,9,8,4};
		bubSort(arr);
		for (int a  : arr) {
	         System.out.print(a+ " ");
	      }
		
	}
	
	//method that bubble sorts an array from smallest to largest
	public static void bubSort(int[] arr){
		int len = arr.length;
		int temp;
		for(int i=0;i<len-1;i++){
			for(int j=0;j<len-1;j++){
				if(arr[j]>arr[j+1]){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
	}

}
