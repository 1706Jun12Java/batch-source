/*
 * Write a program that demonstrates the switch case. Implement the following
 * functionalities in the cases: 
 * Case 1: Find the square root of a number using the Math class method.
 * Case 2: Display today’s date.
 * Case 3: Split the following string and store it in a sting array:
 * 		“I am learning Core Java”
 */
package Switch;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class SwitchCase {

	public static void main(String[] args) {
		
		chooseOption("Math");
		//chooseOption("Date");
		//chooseOption("Split");
    }
	
    public static void chooseOption(String option) {
         switch(option) {
          case "Math":
        	  double value;
        	  Scanner s = new Scanner(System.in);
        	  System.out.println("Enter a number:");
        	  value = s.nextDouble();
        	  double root = Math.sqrt(value);
              System.out.println("Square root of "+value+" is "+root);
              break;
          case "Date":
        	  Date date = new Date();
        	  System.out.println(date);
          case "Split":
        	  String x = "I am learning core java";
        	  String [] y = x.split(" ");
              System.out.println(Arrays.toString(y));
              break;
          default:
              System.out.println("");
              break;
         }
    }
}
