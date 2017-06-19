package com.nima.q4;

public class Q4 {
	
	//Q4. Write a program to compute N factorial.
	
	 public static void main(String[] args){
	        
	        int i = 0,fact = 1;
	        int num = 5;//Number to calculate factorial
	        //loop to calcualte the factorial
	        for(i=1;i<=num;i++){
	            fact=fact*i;
	        }
	        //print the calculated value
	        System.out.println("Number: "+num+"\nFactorial: "+fact);
	    }

}
