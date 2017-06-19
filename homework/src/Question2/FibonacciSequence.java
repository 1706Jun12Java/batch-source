package Question2;

public class FibonacciSequence {
	public static void main(String[] args) {
		int x1= 0;
		int x2=1;
		int x3;
		int count = 25;
		System.out.print(x1);
		System.out.print(",");
		System.out.print(x2);
		//use for loop to create sequence
		for (int i=2; i<count; i++){
			//add current values then switch them to there preceding number
			x3 = x1 + x2;
			x1 = x2;
			x2 = x3;
			System.out.print(","+x3);
		}
	}
}
