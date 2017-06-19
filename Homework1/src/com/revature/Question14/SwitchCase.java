package com.revature.Question14;

import java.time.LocalDate;
import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter 1 or 2 or 3: ");
		int x = sc.nextInt(); 
		
		
		switch(x){
		case 1:
			System.out.println("Square root of 81 is: " + Math.sqrt(81));
			break;
		
		case 2:
			System.out.println("Today is " + LocalDate.now());
			break;
		case 3:
			String[] array = "I am learning Core Java".split(" ");
			for (int s=0; s<=array.length-1;s++){
				System.out.print(array[s] + " ");
			};
			break;
		}
	}

}
