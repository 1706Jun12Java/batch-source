package calculator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		calculator();
	}

	public static void calculator() {
		System.out.println("=========================\nWelcome to MyCalculator\n=========================\n");
		System.out.print("Enter operator: +, -, *, / :  ");
		try (Scanner scan = new Scanner(System.in)) {
			
			String op = scan.nextLine();

			while (!(op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/"))) {
				System.out.println("Enter operator: +, -, *, / :  ");
				op = scan.nextLine().trim();
			}

			float firstNum = 0;
			float secNum = 0;
			boolean flag = false;

			do {
				System.out.print("Enter the first number :  ");
				try {
					firstNum = scan.nextFloat();
				} catch (NumberFormatException e) {
					flag = true;
				}
			} while (flag);

			do {
				System.out.print("Enter the second number :  ");
				try {
					secNum = scan.nextFloat();
				} catch (NumberFormatException e) {
					flag = true;
				}
			} while (flag);

			float result = 0;

			switch (op) {
			case "+":
				result = firstNum + secNum;
				break;
			case "-":
				result = firstNum - secNum;
				break;
			case "*":
				result = firstNum * secNum;
				break;
			case "/":
				result = firstNum / secNum;
				break;
			}

			if (result == (int) result) {
				System.out.println((int) result);
			} else {
				System.out.println(result);
			}

		}

	}
}
