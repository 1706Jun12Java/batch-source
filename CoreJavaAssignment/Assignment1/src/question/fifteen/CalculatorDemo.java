package question.fifteen;

public class CalculatorDemo {

	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		
		System.out.println("Addition: " + calc.addition(7, 3));
		System.out.println("Subtraction: " + calc.subtraction(7, 3));
		System.out.println("Multiplication: "  + calc.multiplication(7, 3));
		System.out.println("Division: " + calc.division(7, 3));


	}

}
