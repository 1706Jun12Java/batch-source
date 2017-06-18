package Question15;

/**
 * Write a program that defines an interface having the following methods: addition,
 * subtraction, multiplication, and division. Create a class that implements this interface
 * and provides appropriate functionality to carry out the required operations. Hard code
 * two operands in a test class having a main method that calls the implementing class.
 * <p>
 * Created by John on 6/17/2017.
 */
public class InterfaceExample
{
    public static void main(String[] args)
    {
        Calculator calculator = new Calculator();

        System.out.println("Calculator addition: " + calculator.addition(5, 9));
        System.out.println("Calculator subtraction: " + calculator.subtraction(5, 9));
        System.out.println("Calculator multiplication: " + calculator.multiplication(5, 9));
        System.out.println("Calculator division: " + calculator.division(20, 2));
    }
}
