package question.nineteen;

import java.util.ArrayList;

public class ArrayLists {

	public static void main(String[] args) {
		ArrayList<Integer> myArrayList = new ArrayList<>();
		myArrayList.add(1);
		myArrayList.add(2);
		myArrayList.add(3);
		myArrayList.add(4);
		myArrayList.add(5);
		myArrayList.add(6);
		myArrayList.add(7);
		myArrayList.add(8);
		myArrayList.add(9);
		myArrayList.add(10);
		
		System.out.println("myArrayList: " + myArrayList);
		
		int evenNumbers = 0;
		int oddNumbers = 0;
		
		//adding even and odd numbers respectively in the proper variable. 

		for(int i=0; i<myArrayList.size(); i++){
			if (myArrayList.get(i)%2==0){
				evenNumbers+=myArrayList.get(i);
			}
			else
				oddNumbers+=myArrayList.get(i);
		}
		System.out.println("The sum of all even numbers in myArrayList is: " + evenNumbers);
		
		System.out.println("The sum of all odd numbers in myArrayList is: " + oddNumbers);

		//remove prime numbers from the ArrayList and print out the remaining arrayList
		for(int i=myArrayList.size()-1; i>=0; i--){
			if(isPrime(myArrayList.get(i))==true){
				myArrayList.remove(i);
				i++;
			}
			
		}
		System.out.println("myArrayList with no prime numbers: " + myArrayList);
			
		}
	
	public static boolean isPrime(int n){
		if(n==1){
			return false;
		}
		for(int i=2; i<n; i++){
			if (n%i == 0) {
				return false;
			}
		}
		return true;
	}
}