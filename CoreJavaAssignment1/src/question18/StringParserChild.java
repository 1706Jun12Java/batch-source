package question18;

public class StringParserChild extends StringParser{

	@Override
	boolean hasUppercase(String a) {
		String temp = a.toLowerCase();
		if(a.equals(temp)){
			return false;
		}
		return true;
	}

	@Override
	String toUppercase(String a) {
		return a.toUpperCase();
	}

	@Override
	int addTen(String a) {
		return Integer.parseInt(a) + 10;
	}

}
