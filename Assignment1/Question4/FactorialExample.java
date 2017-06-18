package Question4;

/**
 * Write a program to compute N factorial.
 * <p>
 * Created by John on 6/16/2017.
 */
public class FactorialExample
{
    public static void main(String[] args)
    {
        int ex = 3;
        int result = factorial(ex);
        System.out.println(result);
    }

    private static int factorial(int number)
    {
        if (number == 1)
            return 1;

        return number * factorial(number - 1);
    }
}
