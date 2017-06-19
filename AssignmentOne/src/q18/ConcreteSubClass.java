package q18;

//Write a program having a concrete subclass that
//inherits three abstract methods from a superclass.  
//Provide the following three implementations in the 
//subclass corresponding to the abstract methods in the superclass: 
//1.Check for uppercase characters in a string, and return ‘true’
//or ‘false’ depending if any are found.
//2.Convert all of the lower case characters to uppercase 
//in the input string, and return the result. 
//3.Convert the input string to integer and add 10,
//output the result to the console.
//Create an appropriate class having a main method to test the above setup.

public class ConcreteSubClass {

	public static void main(String[] args) {

		SubClass sub = new SubClass();
		String a = "HeLLoWoRlD";
		String b = "10";
		
		System.out.println("Your string has upper case: " + sub.uppercase(a));
		System.out.println("This is your string with all uppercase: " + sub.lowerToUpper(a));
		System.out.println("When adding 10 to your number you get: " + sub.addInt(b));
	}

}
