package question14;
import java.math.*;
import java.util.Date;
import java.util.Scanner;

public class Question14 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value between 1 to 3:");
        int n = scanner.nextInt();
        switch(n) {
        case 1 :
           System.out.println("Enter a value to be square rooted?");
           double input = scanner.nextDouble();
           System.out.println(Math.sqrt(input));
           break; 
        
        case 2 :
        	Date abc = new Date();
        	StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(abc.getYear());
			stringBuilder.append(" ");
			stringBuilder.append(abc.getMonth());
			stringBuilder.append(" ");
			stringBuilder.append(abc.getDate());
			System.out.println(stringBuilder.toString());
           break;
           
        case 3:
        	String abcd = "I am learning Core Java";
        	String abcArray[]= abcd.split(" ");
        	for(int i=0; i < abcArray.length; i++){
                System.out.println(abcArray[i]);}
        	break;
        
        // You can have any number of case statements.
        default : // Optional
           System.out.println("Bing Bong");
     }
        
        
    }
	}


