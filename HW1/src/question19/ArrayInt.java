package question19;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayInt {

	public static void main(String[] args) {
		ArrayList<Integer> aln = new ArrayList<Integer>();
		int evenSum = 0;
		int oddSum = 0;
		for(int i = 0; i<10;i++){
			aln.add(i+1);
			if((i+1)%2 == 0){
				evenSum += i+1;
			} else {
				oddSum += i+1;
			}
		}
		System.out.println("The sum of all even numbers from 1-10: " + evenSum);
		System.out.println("The sum of all odd numbers from 1-10: " + oddSum);
		for (Iterator<Integer> iterator = aln.iterator(); iterator.hasNext();) {
		    int next = iterator.next();
		    if (isPrime(next)) {
		        iterator.remove();
		    }
		}
		System.out.println("\nArraylist with removed prime numbers:");
		for(int a : aln){
			System.out.println(a);
		}
	}
	
	public static boolean isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false;
	    }
	   return true;
	}

}