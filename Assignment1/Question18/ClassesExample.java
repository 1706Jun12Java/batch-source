package Question18;

/**
 * Write a program having a concrete subclass that inherits three abstract methods
 * from a superclass. Provide the following three implementations in the subclass
 * corresponding to the abstract methods in the superclass:
 * 1. Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
 * <p>
 * 2. Convert all of the lower case characters to uppercase in the input string, and return the result.
 * <p>
 * 3. Convert the input string to integer and add 10, output the result to the console.
 * <p>
 * Create an appropriate class having a main method to test the above setup.
 * <p>
 * Created by John on 6/18/2017.
 */
public class ClassesExample extends StringOperation
{

    @Override
    boolean checkForUppercase(String s)
    {
        String[] words = s.split(" ");

        char[] c;
        for (String str : words)
        {
            c = str.toCharArray();

            for (int i = 0; i < str.length(); i++)
            {
                if (c[i] == str.toUpperCase().charAt(i))
                    return true;
            }
        }

        return false;
    }

    @Override
    String lowerToUppercase(String s)
    {
        return s.toUpperCase();
    }

    @Override
    void stringToInteger(String s)
    {
        int result = Integer.parseInt(s);
        System.out.println(result + 10);
    }
}
