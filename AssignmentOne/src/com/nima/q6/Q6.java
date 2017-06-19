package com.nima.q6;

public class Q6 {

	//Q6. Write a program to determine if an integer is even without using the modulus operator (%)
	
public static void main(String[] args){
        
        int number = 12;    //number to be checked
        int quotient = number/2;    //get the quotient
        //check if its even
        if(quotient*2 == number){
            //print the message if its even
            System.out.println("Even number");
        }//else, print the message for Odd
        else System.out.println("Odd Number");
    }
}
