package Question10;

import java.io.*;
import java.util.Scanner;

public class TernaryOperators {

	public static void main(String[] args) {

		int a=4;
		int b=5;

		Scanner io = new Scanner(System.in);

		//a = io.nextInt();
		//b = io.nextInt();

		System.out.println(min(a, b) ); 
		
	}
	
	public static int min(int a, int b)
	{
		return a>b? b: a;  
		
		
	}
	
	
	

}
