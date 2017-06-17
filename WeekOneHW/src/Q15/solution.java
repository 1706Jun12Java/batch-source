package Q15;

public class solution {

//	 Write a program that defines an interface having the following methods: 
//		addition, subtraction, multiplication, and division.  
//		Create a class that implements this interface and provides 
//		appropriate functionality to carry out the required operations. 
//		Hard code two operands in a test class having a main method that 
//		calls the implementing class.
		
	public static void main(String[] args) {
		
		CalculationClass c =  new CalculationClass();
		System.out.println(c.addition(1, 2));
		System.out.println(c.substraction(1, 2));

	}

}

interface Calculation {
	float addition(float o1, float o2);
	float substraction(float o1, float o2);
	float multiplication(float o1, float o2);
	float division(float o1, float o2); 
}

class CalculationClass implements Calculation{

	@Override
	public float addition(float o1, float o2) { 
		return o1 + o2;
	}

	@Override
	public float substraction(float o1, float o2) { 
		return o1-o2;
	}

	@Override
	public float multiplication(float o1, float o2) { 
		return o1*o1;
	}

	@Override
	public float division(float o1, float o2) {  
		return o1/o2;
	}
	
}
