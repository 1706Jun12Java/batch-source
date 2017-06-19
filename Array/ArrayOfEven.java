/*
 * Write a program to store numbers from 1 to 100 in an array. Print out all the even 
 * numbers from the array. Use the enhanced FOR loop for printing out the numbers.
 */
package Array;

public class ArrayOfEven {

	public static void main(String[] args) {
		// 
		int [] a = new int[100];
		for (int i=0;i <100;++i){
			a[i]=i;
		}		
		for (int even : a){
			if (a[even] % 2 == 0){
				System.out.print(a[even]+",");
			}
		}
	}
}

