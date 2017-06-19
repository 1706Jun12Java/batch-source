package question11;

import question11a.AscessFloats;

public class Question11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AscessFloats abc = new AscessFloats(2, 3);
		System.out.println(abc.a +" "+ abc.b);
		abc.setA(10);
		abc.setB(5);
		System.out.println(abc.a +" "+ abc.b);
	}

}
