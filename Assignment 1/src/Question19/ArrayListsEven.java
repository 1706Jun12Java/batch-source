package Question19;

import java.util.ArrayList;

public class ArrayListsEven {

	
	public static boolean isPrime(int num){
		
		for(int x=2; x*x<100; x++)
		{ if (num%x==0) return false; }
		
		return true; 
		
		
	}
	
	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<Integer>(); 
		
		for(int x=0;x<10; x++) arr.add(x);
		
		for(int x : arr) System.out.println(x);
		
		int sumEven=0; 
		
		//display even
		for(int x: arr) {if(x%2==0)  sumEven+=x;}
		
		System.out.println("the sum of evens is " +sumEven);
		
		int sumOdd=0;int sumPrime=0;
		
for(int x: arr) {if(x%2==1)  sumOdd+=x;}
		
		System.out.println("the sum of odds is " +sumOdd);
		
		for(int x=0; x<10; x++) if(isPrime(x)) { sumPrime+=x;  System.out.println(sumPrime);}
		
		
		
		
		
		
		
		
	}

}
