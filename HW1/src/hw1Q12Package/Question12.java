package hw1Q12Package;

import java.util.ArrayList;
import java.util.List;

public class Question12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = new int[100];
		for(int i = 0; i < num.length; i++){
			num[i] = i+1;
			
		}
		for(int myValue : num){
			if(num[myValue] % 2 == 0){
				System.out.print(num[myValue] + " ");
				
			}
		}

		
		
	}

}
