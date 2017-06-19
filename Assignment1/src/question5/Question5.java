package question5;
import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		
		
		int index = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter what you want to type and press enter?");
		String str = sc.nextLine();
		
		System.out.println("Please enter the index number you want to pick from the string of" + str.length());
		index = sc.nextInt();
		System.out.println(str.charAt(index-1));

	}

}
