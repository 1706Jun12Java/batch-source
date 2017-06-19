package Question6;

public class IsEven {

	public static void main(String[] args) {

		int number = 5;
		int quotient = number / 2;
		if (quotient * 2 == number) {
			System.out.println("This is an even number");
		}
		else {
			System.out.println("This is an odd number");
		}
	}
}
