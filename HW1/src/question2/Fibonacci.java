package question2;

public class Fibonacci {

	public static void main(String[] args) {
		
		//number of elements to generate in a series 
		 

		long[] series = new long[25]; 

		//create first 2 series elements 
		series[0] = 0; 
		series[1] = 1; 

		//create the Fibonacci series and store it in an array 
		for(int i=2; i < 25; i++) 
		{ 
		series[i] = series[i-1] + series[i-2]; 
		} 

		//print the Fibonacci series numbers 

		System.out.println("Fibonacci Series up to 25 " ); 
		for(int i=0; i< 25; i++) 
		{ 
		System.out.print(series[i] + " "); 
		} 
	
	}

}
