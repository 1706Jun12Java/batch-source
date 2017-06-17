package Q4;

public class Solution {

//	Write a program to compute N factorial.
	
	public static void main(String[] args) {
		 
		System.out.println("10! = "+factorial(10));

	}
	
	public static long factorial (int N){
		
		long cumulatedProd = 1;
		
		for (int i=1; i<=N; i++){
			cumulatedProd *= i; 
		}
		 
		return cumulatedProd;
	}

}
