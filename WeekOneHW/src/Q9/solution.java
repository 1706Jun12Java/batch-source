package Q9;

public class solution {
	
//	Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime
//	numbers to the console.

// O(n^2)
	
	public static void main(String[] args) {
		int[] isPrime = new int[101]; 
		
		for (int i = 1; i < isPrime.length; i++){
			isPrime[i] = 1;
		}
		 
		
		for (int i = 2; i < isPrime.length; i++){
			if (isPrime[i] == 1){
				for (int j = i*2; j < isPrime.length; j = j+i){
					isPrime[j] = 0;
				}
			} 
		}
		
		for (int i = 2; i < isPrime.length; i++ ){
			if (isPrime[i] == 1){ 
				System.out.println(i);
			}
		} 
	} 
}
