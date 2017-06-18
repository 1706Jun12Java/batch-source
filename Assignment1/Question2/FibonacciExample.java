package Question2;

/**
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 * <p>
 * Created by John on 6/15/2017.
 */
public class FibonacciExample
{
    public static void main(String[] args)
    {
        int range = 25;

        for (int i = 0; i < range; i++)
        {
            System.out.print(fibonacciSequence(i) + " ");
        }
    }

    private static int fibonacciSequence(int number)
    {
        if (number == 0)
            return 0;

        if (number == 1 || number == 2)
            return 1;

        return fibonacciSequence(number - 1) + fibonacciSequence(number - 2);
    }
}
