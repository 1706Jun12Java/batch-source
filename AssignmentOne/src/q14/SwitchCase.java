package q14;

import java.math.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Write a program that demonstrates the switch case.
//Implement the following functionalities in the cases:
//Case 1: Find the square root of a number using the Math class method. 
//Case 2: Display today’s date.
//Case 3: Split the following string and store it in a string array. 
//       “I am learning Core Java”
public class SwitchCase {

	public static void main(String[] args) {

		int a = 1;//change this number to change the case.

		switch (a) {
		case 1:
			System.out.println(Math.sqrt(Math.random()));//finds the
			break;							//square root of a random number
		case 2:
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate todaysDate = LocalDate.now();
			System.out.println(dateFormat.format(todaysDate));
			break;
		case 3:
			String java = "I am learning core Java";
			String[] array = java.split(" ");//splits the string
			for (String b : array) {//displays the string.
				System.out.println(b);
			}
			break;
		default:
			System.out.println("ERROR");
			break;
		}
	}
}
