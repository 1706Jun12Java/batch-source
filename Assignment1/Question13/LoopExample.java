package Question13;

/**
 * Display the triangle on the console as follows using any type of loop. Do NOT use
 * a simple group of print statements to accomplish this.
 * 0
 * 1 0
 * 1 0 1
 * 0 1 0 1
 * <p>
 * Created by John on 6/17/2017.
 */
public class LoopExample
{
    public static void main(String[] args)
    {
        int alternate = 0;

        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                System.out.print(alternate + " ");

                if (alternate == 0)
                    alternate++;
                else
                    alternate--;
            }
            System.out.println();
        }
    }
}
