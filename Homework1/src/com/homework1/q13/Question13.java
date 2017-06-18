package com.homework1.q13;

public class Question13 {
	public static void main(String[] args) {
		boolean x = false;
		for(int i=0;i<4;i++){
			for(int j=0; j<=i;j++){
				if(x){
					System.out.print("1 ");
				}else{
					System.out.print("0 ");
				}
				x=!x;
			}
			System.out.println();
		}
	}
}
