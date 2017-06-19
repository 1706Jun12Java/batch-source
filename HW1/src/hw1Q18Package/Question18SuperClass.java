package hw1Q18Package;

import java.util.Scanner;

public abstract class Question18SuperClass {
	
	
	
	abstract void checkCase(String str);

	abstract void toLower(String str);

	abstract void toIntPlusTen(String str);

	public static void main(String[] args) {
		Question18SuperClass example = new Question18SubClass();
		example.checkCase("What");
		System.out.println();
		example.toLower("LOWER ME PLEASE");
		System.out.println("\nEnter something:");
		Scanner input = new Scanner(System.in);
		example.toIntPlusTen(input.nextLine().toString());
		
	}

}
