package com.revature.Question12;

public class evenArray {

	public static void main(String[] args) {
		
		int[] myArray=new int[100];
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			myArray[i]=i+1;
			
		}
		
//		for(int x:myArray){
//			System.out.print(myArray[x-1] +" ");
//		}
		
		for(int x: myArray){
			x=--x;
			if(myArray[x]%2==0){
				System.out.print(myArray[x] + " ");
				
			}
		}
	}

}
