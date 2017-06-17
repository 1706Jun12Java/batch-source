package q19;

import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		/*Create an ArrayList and insert integers 1 through 10. 
		Display the ArrayList. 
		Add all the even numbers up and display the result. 
		Add all the odd numbers up and display the result. 
		Remove the prime numbers from the ArrayList and print out the remaining ArrayList.*/
		
		// Create an ArrayList 
		ArrayList<Integer> a = new ArrayList<Integer>(); 
		
		// Insert integers 1 through 10 
		for (int i=1;i<=10;i++){
			a.add(i);
		}
		
		// Display the ArrayList
		for (Integer i:a){
			System.out.print(i + " ");
		}
		
		System.out.println(" ");
		
		// Add all the even numbers up and display the result. 
		System.out.println(" ");
		System.out.print("Even Numbers: ");
		int evenTotal =0;
		for (Integer i: a){
			if(i%2==0){
				System.out.print(i + " ");
				evenTotal += i;
			}
		}
		System.out.println(" ");
		System.out.println("Even Total: " + evenTotal);
		
		// Add all the odd numbers up and display the result. 
				System.out.println(" ");
				System.out.print("Odd Numbers: ");
				int oddTotal =0;
				for (Integer i: a){
					if(i%2!=0){
						System.out.print(i + " ");
						oddTotal += i;
					}
				}
				System.out.println(" ");
				System.out.println("Odd Total: " + oddTotal);
		
		// Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
				for (int i = 0; i < a.size(); i++){
					if(isPrime(a.get(i))){
						a.remove(i);
					}
				}
				
				
				System.out.println(" ");
				
		// Display ArrayList
				System.out.print("Final Array List:  ");
				for(Integer i : a){
					System.out.print(i + " ");
				}
	}
	
	static boolean isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return false; // number is divisible so its not prime
	    }
	    return true; // number is prime now
	}
	
}
