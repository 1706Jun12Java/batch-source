package com.revature.lambda;

public class Main {
	
	public static void main(String[] args){
		Odd o = (a) -> {
			if(a%2!=0){
				return true;
			}
			else{
				return false;
			}
		};
		
		Prime p = a->{
			if(a<1){
				return false;
			}
			if(a==1 || a ==2){
				return true;
			}else{
				for(int i=2; i<=Math.sqrt(a);i++){
					if(a%i==0){
						return false;
					}
				}
			}
			return true;
		};
		
		Palindrome pa = a -> {
			String x = Integer.toString(a);
			String y = new StringBuilder(x).reverse().toString();
			if(x.equals(y)){
				return true;
			}
			else{
				return false;
			}
		};
		
		System.out.println(o.isOdd(5));
		System.out.println(o.isOdd(6));
		System.out.println(p.isPrime(6));
		System.out.println(p.isPrime(7));
		System.out.println(pa.isPalindrome(5));
		System.out.println(pa.isPalindrome(11));
		System.out.println(pa.isPalindrome(12));
		
	}
	
}
