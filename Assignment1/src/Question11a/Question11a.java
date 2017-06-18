package Question11a;

import Question11b.Question11b;

public class Question11a {
	public static void main(String[] args) {
		// access the values from a different package
		Question11b.x = 5;
		Question11b.y = 15;
		System.out.println(Question11b.y + Question11b.x);
	}
}
