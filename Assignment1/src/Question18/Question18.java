package Question18;

public class Question18 {

	public static void main(String[] args) {
		// Test the SubClass extending AbstractBaseClass
		SubClass sub = new SubClass();
		System.out.println(sub.hasUpperCase("This Should Say True"));
		System.out.println(sub.hasUpperCase("this should say false"));
		System.out.println(sub.toUpperCase());
		sub.toIntPlus10();

	}

}
