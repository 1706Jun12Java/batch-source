package q11p1;

public class Main {

	public static void main(String[] args) {
		// Write a program that would access two float-variables from a class that exists in another package. 
		// Note, you will need to create two packages to demonstrate the solution. (q11p2). 
		q11p2.Main m = new q11p2.Main();
		System.out.println(m.getI());
		System.out.println(m.getJ());
		

	}

}
