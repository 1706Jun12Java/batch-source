package com.nima.q12;

import java.util.ArrayList;

public class Q12 {
	
	/*
	 * Q12. Write a program to store numbers from 1 to 100 in an array.
	 *  Print out all the even numbers from the array. 
	 * Use the enhanced FOR loop for printing out the numbers.
	 * 
	 */
    
    public static void main(String[] args){
        
        //create and al 1-100 numbers in array list
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i+1);
        }
        //loop for each number to know if its a even number
        for (int i = 0; i < 100; i++) {
            if(list.get(i)%2 == 0){
                //print only the even numbers
                System.out.print(list.get(i)+" ");
            }
        }
        
    }
}