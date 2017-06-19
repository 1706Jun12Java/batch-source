package question9;

import java.util.ArrayList;

/*public class PrimeArray {
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i< 100;i++){
			list.add(i+1);
			PrimeNum(i);
		}
	}
	  
	public static void PrimeNum(int n) {
	    for(int i=2;i<n;i++) {
	        if(n%i==0)
	            return;
	    }
	  
	    System.out.println(n);
	}
}*/
public class PrimeArray{
    public static void main(String[] args) {
        

        System.out.println("Generate Prime numbers between 1 and 100. \"1\" is not prime.");

        ArrayList<Integer> list = new ArrayList<Integer>();

        // loop through the numbers one by one
        for (int n = 1; n < 100; n++) {
            boolean prime = true;
            // analyzes if n is prime

            for (int j = 2; j < n; j++) {
                if (n % j == 0) {
                    prime = false;
                    break; // exit the inner for loop
                    }
            }
            if (prime && n != 1) {
                list.add(n);
            }
        }
        for (int i : list) {
            System.out.println(i + " ");
        }
    }
}