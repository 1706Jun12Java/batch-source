package com.revature.Question19;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListPrint {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		int x = 0;

		while (x <= 10) {
			list.add(x);
			x++;
		}
		int evensum = 0;
		int oddsum = 0;
		
		System.out.println("Orignal ArrayList: " + list.toString());

		for (int i : list) {
			if (list.get(i) % 2 == 0)
				evensum += list.get(i);
			else
				oddsum += list.get(i);
			
		}
		System.out.println("\n\nSum Of Even Numbers: " + evensum + "\nSum of Odd Numbers: " + oddsum);

		
		System.out.println();
		Iterator<Integer> iter = list.iterator();
		
		while(iter.hasNext()){	
			int n = iter.next();
			
			if(isPrime(n))
				iter.remove();
		}
		
		System.out.println("Removal of Prime Numbers: " + list.toString());
		
		
		
		
		
	}

	private static boolean isPrime(int num) {
		if (num % 2 == 0)
			return false;
		for (int i = 3; i * i <= num; i += 2)
			if (num % i == 0)
				return false;
		return true;
	}
}
