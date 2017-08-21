package com.revature.primechecker;


public class Prime {

	public boolean isPrime(int n) 
	{
	    for(int i=2;i<n;i++) 
	    {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}

	public void checkPrime(int... numbers) {

		for (int num : numbers) {
			System.out.print(isPrime(num) ? "" + num + " " : "");
		}
		System.out.println("");
	}
}
