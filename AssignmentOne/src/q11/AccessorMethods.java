package q11;

//Write a program that would access
//two float-variables from a class that exists
//in another package. Note, you will need to create
//two packages to demonstrate the solution.
public class AccessorMethods {

	public static void main(String[] args) {

		q10.q11Floats.setA(8);
		System.out.println(q10.q11Floats.getA());

		q10.q11Floats.setB(5);
		System.out.println(q10.q11Floats.getB());
	}

}
