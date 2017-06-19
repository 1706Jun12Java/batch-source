package Question4;

public class Factorial {

	public static void main(String[] args) {

		//create int variables
		int number = 5;
		int increase = 1;
		//use for loop to multiply previous number by current number
		for (int i = 1; i <= number; i++) {
			increase = increase * i;
		}
		System.out.println("The Factorial of "+number+ " is " +increase);
	}

}
