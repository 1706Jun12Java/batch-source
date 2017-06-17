package Q2;

import java.util.ArrayList;

public class QuestionTwo {

	public static void main(String[] args) {
//		Write a program to display the 
//		first 25 Fibonacci numbers beginning at 0.
		
// O(n)
		
		ArrayList<Integer> fib = new ArrayList<Integer>();
		int i = 1;
		int j = 1;
		fib.add(i);
		fib.add(j);
		
		for (int ii=2; ii<25; ii++){  
			int k = i+j; 
			fib.add(k); 
			i = j;
			j = k; 
		} 
		
		fib.forEach(x -> System.out.println(x)); 

	}

}
