package com.nima.q9;
import java.util.ArrayList;

public class Q9 {

/*
 * Q9. Create an ArrayList which stores numbers from 1 to 100 
 * and prints out all the prime numbers to the console.
 * 
 */
	 public static void main(String[] args){
	        //create and al 1-100 numbers in array list
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        for (int i = 0; i < 100; i++) {
	            list.add(i+1);
	        }
	        //call method fot each number to knowm if its a prime number
	        for (int i = 0; i < 100; i++) {
	            if(isPrime(list.get(i))){
	                //print only the prime numbers
	                System.out.print(list.get(i)+" ");
	            }
	        }
	        
	    }
	    //Method to check if the number is prime or not
	    public static boolean isPrime(int number) {
	        //check if number is prime
	        for(int i=2;i<number;i++) {
	            if(number%i==0){
	                return false;
	            }
	        }
	        return true;
	    }
}
