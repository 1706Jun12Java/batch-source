package question.thirteen;

public class Triangle {

	public static void main(String[] args) {
		displayTriangle();
	}

	public static void displayTriangle(){
		
		int lastDigit = 0;
		for (int i=0; i < 4; i++) {
			for (int j=0; j<=i; j++) {
				
				System.out.print(lastDigit + " ");
				lastDigit = (lastDigit == 1) ? 0: 1;
			}
			System.out.println();
		}
	}
}