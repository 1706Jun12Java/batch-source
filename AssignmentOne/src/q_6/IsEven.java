package q_6;

//Write a program to determine if an integer
//is even without using the modulus operator (%)
public class IsEven {

	public static void main(String[] args) {
		int i = 2345;
		int j = 2456;

		System.out.println(isEven(i));
		System.out.println(isEven(j));

	}

	public static String isEven(int i) {

		String even = "This number is not even";
		int quotient = i / 2;// divide the 'i' by 2
		if (quotient * 2 == i) {// multiply the quotient by 2 and compare it to
								// 'i'
								// if the new number does not equal 'i' then
								// its not even.
			even = "This number is even";
			return even;
		}
		return even;
	}

}