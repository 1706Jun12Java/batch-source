package Question11.packageAccess;

import Question11.floatNumbers.NumberInPackage;

/**
 * Write a program that would access two float-variables from a class that exists in
 * another package. Note, you will need to create two packages to demonstrate the solution.
 * <p>
 * Created by John on 6/17/2017.
 */
public class AccessExample
{
    public static void main(String[] args)
    {
        System.out.println("Accessing two number from a different package. First number: " + NumberInPackage.var
                + " Second Number: " + NumberInPackage.anotherVar);
        System.out.println("Achieved through the public access modifier, and made static to access without instantiation");
    }
}
