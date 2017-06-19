package hw1Q19Package;

import java.util.ArrayList;
import java.util.List;

public class Question19 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		int evenSum = 0;
		int oddSum = 0;
		List<Integer> primeList = new ArrayList<Integer>();
		boolean isPrime = false;
		for(int i = 1; i<=10; i++){
			list.add(i);
		}
		for(int i = 0; i<list.size();i++){
			System.out.print(list.get(i) + " ");
		}
		System.out.print("\nEven numbers:");
		for(int i = 0; i<list.size();i++){
			if(list.get(i) % 2 == 0){
				evenSum += list.get(i);
			}else{
				oddSum += list.get(i);
			}
		}
		System.out.print(evenSum + "\nOdd Numbers:");
		System.out.println(oddSum);
		System.out.println("Array without prime Numbers: ");
		for(int i = 0; i< list.size();i++){

			for(int j=2; j<list.get(i);j++){
				if(list.get(i) % j == 0){
					isPrime = false;
					break;
				}else{
					isPrime = true;
				}
			}
			if(isPrime == false && list.get(i) !=1 && list.get(i) != 2){
				primeList.add(list.get(i));
				isPrime = false;
			}
		}
		for(int i = 0; i < primeList.size(); i++){
			System.out.print(primeList.get(i) + " ");
		}
	}

}

