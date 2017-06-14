package question18;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		StringParserChild spc = new StringParserChild();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string: ");
		String uInput = sc.nextLine();
		if(spc.hasUppercase(uInput)){
			System.out.println("Your string has atleast one Uppercase character");
		}else{
			System.out.println("Your String ha no uppecase characters.");
		}
		System.out.println("Your string in all uppercase: " + spc.toUppercase(uInput));
		System.out.println("Enter a number: ");
		uInput = sc.nextLine();
		if(uInput.matches("^[0-9]*$")){
			System.out.println(uInput + " + 10 = " + spc.addTen(uInput));
		}else {
			System.out.println("Not a valid number");
		}
		sc.close();
	}
}
