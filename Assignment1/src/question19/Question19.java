package question19;

import java.util.ArrayList;

public class Question19 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int sum=0, sum1 =0;
		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int n = 1; n <= 10; n++) {
			num.add(n);
			if(n%2==0){
			sum=sum+n;
				System.out.println(n + " is Even");
			}
			
		}
	System.out.println("total is :" +sum);

	for (int n = 1; n <= 10; n++) {
		if(n%2!=0){
		sum1=sum1+n;
			System.out.println(n + " is odd");
		}
		
	}
System.out.println("total is :" +sum1);


	
	for (int n = 1; n <= 10; n++) {
		int i, m = 0, flag = 0;
		m = n / 2;
		for (i = 2; i <= m; i++) {
			if (n % i != 0) {
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			num.set(n, 0);
			
	}
	
	System.out.println("All the prime is remove from Array " + num);

}
	}
	



