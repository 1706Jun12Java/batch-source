package Question9;

import java.util.ArrayList;

public class PrintingPrimes {

	public static boolean isPrime(int a)
	{
		
		for(int x=2; x*x < a; x++)
		{ if(a%x==0) return false; }
		
		
		return true;
		
		
	}
	
	
	public static void main(String[] args) {

		ArrayList<Integer> arr = new ArrayList<Integer>(); 
		
		for(int x=0; x<100; x++){ arr.add(x); }
		
		for(int a : arr)
		{
			if( isPrime(a) ) {
				System.out.println(a);
				
			}
			
		
		
		}
		
		
		
		
		
		
		
	}

}
