package com.revature.scannerClass;

import java.util.Scanner;

public class ScannerClass {

	public static void main(String[] args) {
		
		String dataType;
		Scanner keyboard = new Scanner(System.in);
		String outPut1= "Please enter a value of the data type given"+'\n';
		
		System.out.print("Please enter a data type as a string"+'\n');
		
		dataType = keyboard.next();
		System.out.println(dataType);
		
		switch (dataType) {
		case "byte":
			byte a;
			System.out.print(outPut1);
			a = keyboard.nextByte();
			System.out.println(a);
			break;
		case "short":
			short b;
			System.out.print(outPut1);
			b = keyboard.nextShort();
			System.out.println(b);
			break;
		case "int":
			int c;
			System.out.print(outPut1);
			c = keyboard.nextInt();
			System.out.println(c);
			break;
		case "long":
			long d;
			System.out.print(outPut1);
			d = keyboard.nextLong();
			System.out.println(d);
			break;
		case "float":
			float e;
			System.out.print(outPut1);
			e = keyboard.nextFloat();
			System.out.println(e);
			break;
		case "double":
			double f;
			System.out.print(outPut1);
			f = keyboard.nextDouble();
			System.out.println(f);
			break;
		case "boolean":
			boolean g;
			System.out.print(outPut1);
			g = keyboard.nextBoolean();
			System.out.println(g);
			break;
		case "char":
			char h;
			System.out.print(outPut1);
			h = keyboard.next().charAt(0);
			System.out.println(h);
			break;
		default:
			System.out.println("Invalid data type");
			break;
		}

		System.out.print("Please enter a another value of the data type given"+'\n');

		keyboard.close();
	}
}
