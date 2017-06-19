package Question19;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayFun {

	public static void main(String[] args) {

		//create ArrayList to hold numbers 1-10
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= 10; i++) {
			list.add(i);
		}
		//display ArrayList
		System.out.println("Here is our Array of Numbers:");
		System.out.println(list+"\n");

		//Add even numbers from the ArrayList
		int x = 0;
		for (int even : list) {
			if (even % 2 == 0) {
				x += even;
			}
		}
		System.out.println("Adding all the even numbers in our Array gives:");
		System.out.println(x+"\n");
		
		//Add odd numbers from the ArrayList
		int y = 0;
		for (int odd : list) {
			if (odd % 2 != 0) {
				y += odd;
			}
		}
		System.out.println("Adding all the odd numbers in our Array gives:");
		System.out.println(y+"\n");
		//Remove prime numbers from the ArrayList
		for (Iterator<Integer> prime = list.iterator();prime.hasNext();){
			if (isPrime(prime.next())){
				prime.remove();
			}
		}
		System.out.println("Removing the prime numbers from our Array yields: ");
		System.out.println(list);
	}
	
	//same method used for Question 9
	private static boolean isPrime(int n) {
		if(n<2){
			return false;
		}
	    for(int i=2;i<n;i++) 
	    {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
}
