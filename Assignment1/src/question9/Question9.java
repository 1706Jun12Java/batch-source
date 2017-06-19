package question9;

import java.util.ArrayList;

public class Question9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> num = new ArrayList<Integer>();
		for (int n = 1; n <= 100; n++) {
			num.add(n);
			int i, m = 0, flag = 0;
			m = n / 2;
			for (i = 2; i <= m; i++) {
				if (n % i == 0) {
					flag = 1;
					break;
				}
			}
			if (flag == 0)
				System.out.println(n + "Number is prime");

		}
	}

}
