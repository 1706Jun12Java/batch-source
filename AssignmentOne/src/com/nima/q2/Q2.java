package com.nima.q2;

public class Q2 {

	//Q2. Write a program to display the first 25 Fibonacci numbers beginning at 0. 
	
	 public static void main(String[] args) {
	        int first=0,second=1,third,i,counter=26;
	        System.out.print(first+" "+second);//printing 0 and 1
	        
	        for(i=2;i<counter;++i){//loop starts from 2 because 0 and 1 are already printed
	            third=first+second;
	            System.out.print(" "+third);   //print the new number generated
	            first=second;
	            second=third;
	        }
	    }
	
	
}
