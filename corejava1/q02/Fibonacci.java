package corejava1.q02;

import java.util.ArrayList;

/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 2
 *     Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */

public class Fibonacci {
	
	public static void displayFib(int num) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		int sum = 0;	
		
		// Iterate from 0 through num
		for(int i = 0; i < num; i++) {
			// WE NEED AT LEAST TWO GIVEN NUMBERS: 0 and 1
			
			if(i == 0) {
				arrayList.add(0);
				sum+=0;
			}
			else if(i == 1) {
				arrayList.add(1);
				sum+=1;
			}
			
			else {
				// HERE WE DO THE SUM WITH THE PREVIOUS 2 NUMBER
				sum+= arrayList.get(arrayList.size()-2);
				arrayList.add(sum);
			}
			
			System.out.println(sum);
		}
		
	}
	
	public static void main(String [] args) {
		
		displayFib(25);
	}
}
