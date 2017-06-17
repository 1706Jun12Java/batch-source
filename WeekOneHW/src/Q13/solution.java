package Q13;

public class solution {
	
//	Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
//    0
//    1 0
//    1 0 1
//    0 1 0 1

	public static void main(String[] args) {
		
		int currentDigit = 0;
		for (int i=0; i<4;i++){
			for(int j =0; j<=i; j++){
				System.out.print(currentDigit+ " ");
				currentDigit = currentDigit==1?0:1;
			}
			System.out.println();
		} 
	} 
}
