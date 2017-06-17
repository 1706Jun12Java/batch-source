package Q6;

//  Write a program to determine if an integer is even without using the modulus
//  operator (%)

public class solution {

	public static void main(String[] args) {
		 
		String str = isItEven(23)? "YES": "NO";
		System.out.println("Is 23 even? " + str);

	}

	public static boolean isItEven(int n){
		return n == (n/2)*2;
	}
}
