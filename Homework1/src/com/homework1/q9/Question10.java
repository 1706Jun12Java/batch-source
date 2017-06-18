package com.homework1.q9;

import java.util.ArrayList;

public class Question10 {
	
	public static boolean isPrime(int n){
		if(n<2){
			return false;
		}
		if(n==2 || n==3){
			return true;
		}else{
			for(int i=2; i<=n/2; i++){
				if(n%i==0){
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i=1;i<101;i++){
			nums.add(i);
			if(isPrime(i)){
				System.out.print(i+" ");
			}
		}
	}

}
