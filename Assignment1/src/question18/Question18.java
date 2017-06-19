package question18;

import java.util.Scanner;

public class Question18 {

	public static void main(String[] args) {
		Shapes a = new Circle();
		Shapes b = new Squares();
		Shapes c = new triangle();
		a.printc();
		b.printd();
		c.printb();
		
		String str = a.uppercase(a.shape);
		System.out.println(str);
		
		str = b.lowercase(b.shape);
		System.out.println(str);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a number");
		int input = sc.nextInt();
		System.out.println(a.add10(input));
		
		
		

	}

}
