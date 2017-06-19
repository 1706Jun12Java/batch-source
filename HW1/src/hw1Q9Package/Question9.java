package hw1Q9Package;

import java.util.ArrayList;
import java.util.List;

public class Question9 {

	public static void main(String[] args) {
		List<Integer> num = new ArrayList<Integer>();
		List<Integer> primeNum = new ArrayList<Integer>();
		boolean isPrime = false;
		for(int i = 1; i<=100 ; i++){
			num.add(i);
		}
		System.out.println("All numbers: \n" + num);
		
		for(int i = 0; i< num.size();i++){
			if(num.get(i)==2)
				primeNum.add(num.get(i));
			for(int j=2; j<num.get(i);j++){
				if(num.get(i) % j == 0){
					isPrime = false;
					break;
				}else{
					isPrime = true;
				}
			}
			if(isPrime == true){
				primeNum.add(num.get(i));
				isPrime = false;
			}
		}
		System.out.println("\nPrime numbers: \n" + primeNum);
	}

}
