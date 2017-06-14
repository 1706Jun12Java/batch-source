package question9;

import java.util.ArrayList;

public class OptimusPrime {
	
	public static void main(String[] args){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0; i< 100;i++){
			al.add(i+1);
			isPrime(i);
		}
	}
	public static void isPrime(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return;
	    }
	    System.out.println(n);
	}
}
