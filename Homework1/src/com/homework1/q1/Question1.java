package com.homework1.q1;

public class Question1 {
	public static void bubbleSort(int[] list){
		int temp;
		for(int i=0;i<list.length;i++){
			for(int j=i;j<list.length-1;j++){
				if(list[j]>list[j+1]){
					temp = list[j+1];
					list[j+1]=list[j];
					list[j]=temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] list = {1,0,5,6,3,2,3,7,9,8,4};
		bubbleSort(list);
		for(int i:list){
			System.out.print(i+" ");
		}
	}

}
