/*
 * Q19 Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all
the even numbers up and display the result. Add all the odd numbers up and display the
result. Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 */
package com.ArrayOps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayOps {

	public static void main(String[] args) {
		
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};	
		List<Integer> b = new ArrayList<Integer>();
		for (int element : a) {
            b.add(element);
        }
		System.out.println("Contents of the array: "+Arrays.toString(a));
				
		// sum up even and  odd numbers in the array
		int sum_even = 0;
		int sum_odd = 0;
		for (int i=0;i<a.length; i++){
			if (a[i] % 2 == 0){
				sum_even += a[i]; 
			} else {
				sum_odd += a[i];
			}
		}
		System.out.println("Sum of all even numbers is: "+sum_even);
		System.out.println("Sum of all odd numbers is: "+sum_odd);
		
		removePrimes(b); //call the method to remove prime numbers
		System.out.println("Contents of the array without prime numbers: "+b);
	}		
	//method to remove prime numbers from ArrayList
	public static void removePrimes( List<Integer> a ){
		  boolean isPrime=false;
		  for(int i=0;i<a.size();i++){
		  isPrime = checkPrime(a.get(i));
		  if(isPrime){
			  a.remove(i);
			  }
		  }
	}
	//method to check if a number is prime	
	static boolean checkPrime(int n) {
		        for(int i=2;i<n;i++) {
		            if(n%i==0)
		                return false;
		        }
		        return true;
		}
}