package question18;

public class AbstractMain {

	public static void main(String[] args) {
		// Test the SubClass extending AbstractBaseClass
		AbstractSubClass sub = new AbstractSubClass();
		System.out.println(sub.hasUpperCase("Should be True"));
		System.out.println(sub.hasUpperCase("Should be False"));
		System.out.println(sub.toUpperCase());
		sub.toIntPlus10();

	}

}