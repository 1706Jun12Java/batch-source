package Question9;

import java.util.ArrayList;

public class Prime {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();

		for ( int count = 1; count<=100;count++){
			if(isPrime(count)){
				//1 is not a prime number so iteration was skipped
				if(count == 1){
					continue;
				}
				list.add(count);
			}
			
		}
		System.out.println(list);
		
	}
	//test for prime number
	private static boolean isPrime(int n) 
	{
	    for(int i=2;i<n;i++) 
	    {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
}

