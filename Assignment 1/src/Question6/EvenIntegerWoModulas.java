package Question6;

import java.util.Scanner;

public class EvenIntegerWoModulas {

	public static void main(String[] args) {

		Scanner a = new Scanner(System.in);
		
		int num = a.nextInt(); 
		a.close();
		
		//java drops dec, so if number/2 is equal to (num-1)/2 , then it is odd 
		// O(1) time
		
		if(num/2 == (num-1)/2) 
			System.out.println("not even");
		else System.out.println("even");
		
		
		
		
		
	}

}
