package com.revature.Question09;

import java.util.ArrayList;
import java.util.List;

public class Question8 {
	
	 private static boolean isPrime(int num) {
	        if (num % 2 == 0)
	            return false;
	        for (int i = 3; i * i <= num; i += 2)
	            if (num % i == 0) return false;
	        return true;
	  }  

	public static void main(String[] args) {
			
		
		List<Integer> listIntegers = new ArrayList<Integer>();
		int i=0;
		
		while(i<100){
			listIntegers.add(i+1);
			i++;
		}
		
		System.out.println("ArrayList Prime items: ");
		for(int x: listIntegers){
			if(isPrime(x))
					System.out.print(x + " ");
		}
		

	}

}
