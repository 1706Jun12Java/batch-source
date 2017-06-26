package q9;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
		ArrayList<Integer> numbers = new ArrayList<Integer>(100);

		for (int i = 1; i <= 100; i++)
		{
		   numbers.add(i);
		   if(isPrime(i)== true){
			   System.out.println(i);
		   }
		}
		
	}
	
	static boolean isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

}


