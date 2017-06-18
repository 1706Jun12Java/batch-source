package question.eighteen;

public class AbstractImplementDemo {

	public static void main(String[] args) {
		AbstractImplementer ai = new AbstractImplementer();
		System.out.println(ai.checkUpperCase("Do I have any upper cases in this string?"));
		System.out.println(ai.convertToUpperCase("HeLLo, this SHOULD be all CAPS."));
		System.out.println(ai.convertStringToInteger("100"));
		

	}

}
