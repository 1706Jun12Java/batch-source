package com.homework1.q12;

public class Question12 {
	public static void main(String[] args) {
		int[] nums = new int[100];
		for(int i=0;i<100;i++){
			nums[i]= i+1;
		}
		
		for(int i:nums){
			if(i%2==0){
				System.out.println(i);
			}
		}
	}
}
