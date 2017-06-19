package q18;

public class SubClass extends AbstractClass {

	SubClass(){
		super();
	}
	
	@Override
	boolean uppercase(String a) {
		
		String lowerCase = a.toLowerCase();// turns the whole string to
											// lowercase
		
		if (a.equals(lowerCase)) {	// compare the 2 strings
			return false;	// if upper case is found return false
		}
		return true;// else the string was lowercase.
	}

	@Override
	String lowerToUpper(String b) {
		// converts the whole string to uppercase.
		return b.toUpperCase();
	}

	@Override
	int addInt(String c) {
		// parse int from c and adds 10 to it.
		return Integer.parseInt(c) + 10;
	}

}
