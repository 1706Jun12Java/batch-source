package question6;

import java.util.Scanner;

public class ICantEven {
	
	public static void main(String[] args){
		System.out.println("Enter a number: ");
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		int divided = num/2;
		if(divided * 2 == num){
			System.out.println("Your number can even!");
		}else {
			System.out.println("Your number can't even- Its acutally pretty odd.");
		}
		sc.close();
	}
}
