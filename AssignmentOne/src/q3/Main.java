package q3;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Reverse a string without using a temporary variable. 
		// To read input:
		Scanner scanner = new Scanner(System.in); 
		
		System.out.println("Enter a string to reverse:");
		String input = scanner.nextLine();
		
		String w = input;
		
		for(int i=0;i<w.length();i++){
			w = w.substring(1, w.length()-i)
					+ w.substring(0,1)
					+ w.substring(w.length()-i,w.length());
		}
		
		
		System.out.println(w);
		
		scanner.close();
	}
	
	

}
