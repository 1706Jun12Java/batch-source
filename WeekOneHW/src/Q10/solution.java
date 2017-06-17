package Q10;

public class solution {

//	Find the minimum of two numbers using ternary operators.

	public static void main(String[] args) {
		
		int i = 1;
		int j = 10;
		
		int min_i_j = (i<j) ? i: j;
		
		System.out.println(String.format("The min of %d, %d is %d", i, j, min_i_j));

	}

}
