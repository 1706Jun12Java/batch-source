package Even;

import java.util.Scanner;

public class EvenNum {

	public static void main(String[] args) {
		System.out.println("Enter a number: ");
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		// 
		if((number / 2)*2==number){
	        System.out.println(number+" is even number");
	    }else{
	        System.out.println(number+" is odd Number");
	    }
		
	}

}
