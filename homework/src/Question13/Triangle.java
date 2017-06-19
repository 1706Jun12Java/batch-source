package Question13;

public class Triangle {

	public static void main(String[] args) {

		int x = 0;
		//create nested for loop
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				//use ternary condition to get desired pattern
				System.out.print(x + " ");
				x = (x%2 == 1) ? 0 : 1;
			}
			System.out.println();
		}

	}
}
