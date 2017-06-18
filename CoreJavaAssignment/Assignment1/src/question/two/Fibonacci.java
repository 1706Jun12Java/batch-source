package question.two;

public class Fibonacci {
	public static void main(String[] args) {
		firstTwentyFiveFib();
	}
	
	public static void firstTwentyFiveFib(){
		int[] fibArray = new int[25];
		for (int i=0; i<25; i++){
			if (i==0){
				fibArray[i] = 0;
				System.out.print(0 + " ");
			}
			else if (i==1){
				fibArray[i] = 1;
				System.out.print(" " + 1);
			}
			else{
				int value = fibArray[i-1] + fibArray[i-2];
				fibArray[i] = value;
				System.out.print(" " + value);
				
			}
			
			
		}
	}

}