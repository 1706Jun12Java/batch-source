package q14;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*Q14. Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
			Case 1: Find the square root of a number using the Math class method. 
			Case 2: Display today’s date.
			Case 3: Split the following string and store it in a sting array. 
			        “I am learning Core Java”*/
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("MENU");
		System.out.println("1 - Find the square root of a number.");
		System.out.println("2 - Display today's date");
		System.out.println("3 - Split the string 'I am learning Core Java' and store it in an array.");
		int option = 0; 
		System.out.println("Enter your option: ");
		option = sc.nextInt();
		
		
		switch (option){
			case 1: 
				System.out.println("Enter a number: ");
				int n = sc.nextInt();
				System.out.println(Math.sqrt(n));
				break;
				
			case 2:
				DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				Date date = new Date();
				System.out.println(dateFormat.format(date)); 
				break;
				
			case 3:
			    String s="I am learning Core Java";
			    char[] a=s.toCharArray();
			    for(char c:a){
			    	System.out.println(c);
			    }
				break;
				
			default:
				System.out.println("This is an invalid option.");
				break;
		
		}


	}

}
