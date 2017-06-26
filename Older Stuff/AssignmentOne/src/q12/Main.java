package q12;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// Write a program to store numbers from 1 to 100 in an array. 
		// Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
		
		ArrayList<Integer> numbers = new ArrayList<Integer>(100);
		for (int i=1;i<=100;i++){
			numbers.add(i);
		}
		
		for(Integer i: numbers){
			if(i%2==0){
				System.out.println(i);
			}
		}


	}

}
