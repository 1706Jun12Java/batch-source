package Question20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Create a notepad file called Data.txt and enter the following:
 * Mickey:Mouse:35:Arizona
 * Hulk:Hogan:50:Virginia
 * Roger:Rabbit:22:California
 * Wonder:Woman:18:Montana
 * <p>
 * Write a program that would read from the file and print it out to the screen in the following format:
 * <p>
 * Name: Mickey Mouse
 * Age: 35 years
 * State: Arizona State
 * <p>
 * Created by John on 6/18/2017.
 */
public class FileIOExample
{
    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File(CompPath.PATH + "Data.txt");

        if (!file.exists())
            System.out.println("The file was not found!");

        Scanner inputFile = new Scanner(file);

        while (inputFile.hasNext())
        {
            String personInfo = inputFile.nextLine();
            String[] infoList = personInfo.split(":");
            personInfo = String.format("Name: %s %s \nAge: %s years \nState: %s State", (Object[]) infoList);
            System.out.println(personInfo + "\n");
        }

        inputFile.close();
    }
}
