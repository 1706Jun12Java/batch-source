package Question10;

/**
 * Find the minimum of two numbers using ternary operators.
 * <p>
 * Created by John on 6/17/2017.
 */
public class TernaryExample
{
    public static void main(String[] args)
    {
        System.out.println(minimum(5, 3));
    }

    /**
     * Compares two numbers and returns the smaller of the two.
     *
     * @param a a number
     * @param b another number
     * @return the minimum between the two numbers
     */
    static int minimum(int a, int b)
    {
        return a > b ? b : a;
    }
}
