package corejava1.q02;

import java.util.ArrayList;

/**
 * 
 * @author Leibniz Berihuete
 *
 */

public class Fibonacci {
	
	public static void displayFib(int num) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		int sum = 0;	
		for(int i = 0; i < num; i++) {
			if(i == 0) {
				arrayList.add(0);
				sum+=0;
			}
			else if(i == 1) {
				arrayList.add(1);
				sum+=1;
			}
			else {
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
