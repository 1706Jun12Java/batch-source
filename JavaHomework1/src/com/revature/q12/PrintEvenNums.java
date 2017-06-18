package com.revature.q12;
/*
 * 
 * Write a program to store numbers from 1 to 100 in an array. 
 * Print out all the even numbers from the array. 
 * Use the enhanced FOR loop for printing out the numbers.
 * 
 */
public class PrintEvenNums {

	public static void main(String[] args) {
		int[] intArray=new int[100];
		for(int i=1;i<=100;i++)
			intArray[i-1]=i;
		for(int num : intArray){
			if(num%2==0)
				System.out.println(num);
		}
	}

}
