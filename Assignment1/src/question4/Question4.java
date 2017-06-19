package question4;

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Factorial number?");
			int fact=1;  
		  int number=sc.nextInt();//It is the number to calculate factorial    
		  
		  
		  for(int i=1;i<=number;i++){    
		      fact=fact*i;    
		  }    
		  System.out.println("Factorial of "+number+" is: "+fact);    
		 

	}

}
