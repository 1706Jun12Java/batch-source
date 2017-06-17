package Q12;

public class solution {
	
//	Write a program to store numbers from 1 to 100 in an array. 
//	Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
	
	public static void main(String[] args){
		
		int[] list = new int[100];
		for (int i = 0; i<100; i++){
			list[i] = i+1;
		}
		
		for(int i: list){
			if(i%2==0){
				System.out.print(i+" ");
			}
		} 
	}
}
