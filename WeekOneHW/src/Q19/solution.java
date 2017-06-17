package Q19;

import java.util.*;

// Create an ArrayList and insert integers 1 through 10. 
// Display the ArrayList. Add all the even numbers up and 
// display the result. Add all the odd numbers up and display the result. 
// Remove the prime numbers from the ArrayList and print out the remaining 
// ArrayList.

public class solution {

	public static void main(String[] args) {
		
		ArrayList<Integer> aList = new ArrayList<>();
		for (int i= 1; i<=10; i++){
			aList.add(i);
		}

		System.out.println(aList);
		
		int totalEven = 0;
		int totalOdd = 0;
		
		for (Iterator<Integer> it = aList.iterator();it.hasNext();){
			int n = (int)it.next();
			if (isEven(n)){
				totalEven += n;
			}
			else{
				if (isOdd(n)){
					totalOdd += n;
				}
				if (isPrime(n)){ 
					it.remove();
				}
			}
		}

		System.out.println("Total Even: "+totalEven);
		System.out.println("Total Odd: "+totalOdd);
		System.out.println(aList);
	}
	
	static boolean isOdd(int n){
		return n%2==1;
	}
	
	static boolean isEven(int n){
		return n%2==0;
	}
	
	static boolean isPrime(int n){
		if (n==1){
			return false;
		}
		if (n==2){
			return true;
		}
		for (int i=2; i<n; i++){
			if(n%i==0){
				return false;
			}
		}
		return true;
	}
}
