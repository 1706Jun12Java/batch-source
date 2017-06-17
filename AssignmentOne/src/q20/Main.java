package q20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		/*=Create a notepad file called Data.txt and enter the following: 
			Mickey:Mouse:35:Arizona
			Hulk:Hogan:50:Virginia
			Roger:Rabbit:22:California
			Wonder:Woman:18:Montana
			 
			Write a program that would read from the file and print it out to the screen in the following format:
			 
			Name: Mickey Mouse
			Age: 35 years
			State: Arizona State
			 */
		

        String csvFile = "..//AssignmentOne//src//q20//Data.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ":";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] person = line.split(cvsSplitBy);

                System.out.println("Name: " + person[0] + " " + person[1]);
                System.out.println("Age: " + person[2] + " years");
                System.out.println("State: " + person[3] + " State");
                System.out.println(" ");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		
		
	}

			
}

/*Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana*/
