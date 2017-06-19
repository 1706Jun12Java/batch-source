package Question10;

public class Minimum {

	public static void main(String[] args) {
		
		int a,b,c;
		//define two variable to compare
		a = 40;
		b = 24;
		//use tenary to find minimum between values
		c = (a<b) ? a : b;
		System.out.println("The minimum value is: "+c);
	}

}
