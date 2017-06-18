package Question15;

/**
 * A simple Class that implements an interface
 * <p>
 * Created by John on 6/17/2017.
 */
public class Calculator implements Calculation
{

    @Override
    public int addition(int a, int b)
    {
        return a + b;
    }

    /**
     * Subtract two number ( a - b)
     *
     * @param a a number
     * @param b another number
     * @return the subtracted value
     */
    @Override
    public int subtraction(int a, int b)
    {
        return a - b;
    }

    @Override
    public int multiplication(int a, int b)
    {
        return a * b;
    }

    @Override
    public int division(int a, int b)
    {
        return a / b;
    }
}
