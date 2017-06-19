package com.revature.Question01;

public class BubbleSort {
	
	public static void main(String[] args){
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		for(int x=0; x<array.length; x++){
			System.out.print(array[x] +" ");
		}
		
		System.out.println();
		
		
		//Begin bubblesort
		for(int i=0; i<array.length;i++){
			for(int j=1; j<array.length-i;j++){
				if(array[j-1] > array[j]){
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j]=temp;
				}
			}
		}
		//end bubblesort
		
		for(int x=0; x<array.length; x++){
			System.out.print(array[x] +" ");
		}
	}

}
