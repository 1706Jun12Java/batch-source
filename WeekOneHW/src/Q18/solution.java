package Q18;

public class solution {

//	Write a program having a concrete subclass that inherits three abstract methods from a superclass.  Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass: 
//		 
//		Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
//		Convert all of the lower case characters to uppercase in the input string, and return the result. 
//		Convert the input string to integer and add 10, output the result to the console.
//		Create an appropriate class having a main method to test the above setup.

		
	public static void main(String[] args) {
		SubClass s = new SubClass();
		
		//test 1
		System.out.println(s.containUpper("Hello"));
		
		//test 2
		System.out.println(s.convertToUpper("Hello"));
		
		//test 3
		s.addTenToIt("100");

	}
}


abstract class SuperClass{
	public abstract boolean containUpper(String str);
	public abstract String convertToUpper(String str);
	public abstract void addTenToIt(String str);
}

class SubClass extends SuperClass{

	@Override
	public boolean containUpper(String str) {
		for (int i=0; i<str.length(); i++){
			if(str.charAt(i)==(Character.toUpperCase(str.charAt(i)))){
				return true;
			}
		}
		return false;
	}

	@Override
	public String convertToUpper(String str) {
		return str.toUpperCase();
		
	}

	@Override
	public void addTenToIt(String str) {
		System.out.println(Integer.parseInt(str)+10); 
	}
	
}
