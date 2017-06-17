package Q14;

import java.text.SimpleDateFormat;
import java.util.*;

public class solution {

//	Write a program that demonstrates the switch case. Implement the following functionalities in the cases:
//		Case 1: Find the square root of a number using the Math class method. 
//		Case 2: Display today’s date.
//		Case 3: Split the following string and store it in a sting array. 
//				“I am learning Core Java”

				
	public static void main(String[] args) {
		  
		int userChooice = 3;
		doStuff(userChooice);

	}
	
	static void doStuff(int userChooice){
		switch (userChooice){
		case 1:
			System.out.println(Math.sqrt(64));
			break;
		case 2: 
			Date date = Calendar.getInstance().getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			System.out.println(sdf.format(date)); 
		case 3:
			String str = "I am learning Core Java";
			String[] arr = str.split(" ");
			for (String a: arr)
				System.out.println(a);
		}
	} 
} 