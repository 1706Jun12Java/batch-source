package com.revature.Question06;

import java.util.Scanner;

public class IsItEven {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Type in a number: ");
		int x = Integer.parseInt(sc.nextLine());
		
		System.out.println(IsItEven(x));
		
	}

	
	static boolean IsItEven(int x){
		while(x>1){
			x+=-2;
		}
		if(x==0)
			return true;
		else
			return false;
		
	}
}
