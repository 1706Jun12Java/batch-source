package question14;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class JustInCase {

	public static void main(String[] args) {
		System.out.println("Enter a case number: ");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		switch(num){
		case 1: System.out.println("Enter a number: ");
				double square = Integer.parseInt(sc.nextLine());
				square = Math.sqrt(square);
				System.out.println("The square root is: " + square);
				break;

		case 2: DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
				LocalDateTime now = LocalDateTime.now();
				System.out.println("Today's date is: " + dtf.format(now));
				break;
		case 3: System.out.println("Splitting string: I am learning Core Java");
				String a = "I am learning Core Java";
				String[] b = a.split(" ");
				System.out.println("The contents of the array: ");
				for(String c: b){
					System.out.println(c);
				}
				break;
		default: System.out.println("Not a valid case");
				 break;
		}
		sc.close();
	}

}
