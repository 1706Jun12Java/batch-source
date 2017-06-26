package q6;
import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		// Write a program to determine if an integer is even without using the modulus operator (%) 

		Scanner sc = new Scanner(System.in);
		System.out.println("Number: ");
		int n = sc.nextInt(); 
		
		int quotient = n/2; 
		
		if(quotient*2 == n)
		{
			System.out.println(n + " is even.");
			
		}else{
			System.out.println(n + " is odd.");
		}
		
		sc.close();

	}

}
