package Question6;

/**
 * Write a program to determine if an integer is even without using
 * the modulus operator (%)
 * <p>
 * Created by John on 6/16/2017.
 */
public class EvenNumberExample
{
    public static void main(String[] args)
    {
        int example = 12;
        int example2 = 8;
        int example3 = 17;
        System.out.println(isEven(example));
        System.out.println(isEven(example2));
        System.out.println(isEven(example3));
    }

    public static boolean isEven(int number)
    {
        Double dWarpNum = (double) number / 2;
        Integer warpNum = number / 2;

        return dWarpNum.compareTo(warpNum.doubleValue()) == 0;
    }
}
