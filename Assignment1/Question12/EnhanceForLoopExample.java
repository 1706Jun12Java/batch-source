package Question12;

/**
 * Write a program to store numbers from 1 to 100 in an array. Print out all the even
 * numbers from the array. Use the enhanced FOR loop for printing out the numbers.
 * <p>
 * Created by John on 6/17/2017.
 */
public class EnhanceForLoopExample
{
    public static void main(String[] args)
    {
        int[] numList = new int[100];

        for (int i = 0; i < 100; i++)
            numList[i] = i;

        for (int x : numList)
            if (x % 2 == 0)
                System.out.print(x + " ");
    }
}
