package question6;

import java.util.Scanner;

public class Question6 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number;
	    Scanner sc= new Scanner(System.in);
	 
	    System.out.println("Enter a number to check even or odd");
	    number=sc.nextInt();
	 
	    if((number / 2)*2==number){
	        System.out.println(+number+" is Even number");
	    }else{
	        System.out.println(+number+" is Odd Number");
	    }
	 
	
		
		
	}

}
