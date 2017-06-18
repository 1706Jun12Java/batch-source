package Question18;

/**
 * Created by John on 6/18/2017.
 */
public class AbstractionExample
{
    public static void main(String[] args)
    {
        ClassesExample ce = new ClassesExample();

        String ex = "string a perSon";
        String numEx = "20";
        System.out.println(ce.checkForUppercase(ex));
        System.out.println(ce.lowerToUppercase(ex));
        ce.stringToInteger(numEx);
    }
}
