/*
 * Create an ArrayList which stores numbers from 1 to 100 
 * and prints out all the prime numbers to the console.
 */
package Prime;
import java.util.ArrayList;

public class Primes {

	public static void main(String[] args) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>(100);

		for (int i = 1; i <= 100; i++){
		   numbers.add(i);
		   //System.out.println(numbers.get(i - 1));
		}
		
		for (Integer num: numbers) {
			int count = 0;
			if (isPrime(num)){
				count++;
				System.out.println(numbers.get(num-1));
			}		    
		}
	}
	
	public static boolean isPrime(int i) {
        int factors = 0;
        int j = 1;

        while(j <= i){
            if(i % j == 0){
                factors++;
            }
            j++;
        }
        return (factors == 2);
  }
}
