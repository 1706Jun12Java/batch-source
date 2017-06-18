package Question16;

/**
 * Write a program to display the number of characters for a string input. The string
 * should be entered as a command line argument using (String [ ] args).
 * <p>
 * Created by John on 6/18/2017.
 */
public class CommandLineExample
{
    public static void main(String[] args)
    {
        if (args.length != 0)
            System.out.println("There are " + args[0].length() + " characters in the string " + args[0]);
        else
            System.out.println("There was no string sent to the main method!");
    }
}
