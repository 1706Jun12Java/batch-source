package question12;

import java.util.ArrayList;

public class Question12 {

	public static void main(String[] args) {
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int n = 1; n <= 100; n++) {
			num.add(n);
			if(n%2==0){
				System.out.println(n + " is Even");
			}
		}
	

	}

}
