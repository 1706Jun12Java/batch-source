package q18;

public class Subclass extends Superclass {

	@Override
	boolean checkUpperCase(String s) {
		
		  for(char c : s.toCharArray())
		    {
		        if(Character.isUpperCase(c))
		            return true;
		    }

		    return false;
	}

	String toUpperCase(String s) {
		return s.toUpperCase();
	}

	@Override
	int toIntPlus10(String s) {
		int n = Integer.parseInt(s); // converts the String to primitive data type int 
		n += 10; 
		return n;
	}

}
