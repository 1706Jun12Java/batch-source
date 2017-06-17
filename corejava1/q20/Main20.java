package corejava1.q20;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

import corejava1.q07.Main7;

/**
 * 
 * @author Leibniz Berihuete
 * QUESTION 20:
 *     Create a notepad file called Data.txt and enter the following:
 *     
 *     Mickey:Mouse:35:Arizona
 *     Hulk:Hogan:50:Virginia
 *     Roger:Rabbit:22:California
 *     Wonder:Woman:18:Montana
 *     
 *     Write a program that would read from the file and print it out to the screen in the
 *     following format:
 *     
 *     Name: Mickey Mouse
 *     Age: 35 years
 *     State: Arizona State	
 */
public class Main20 {
	public static void main(String [] args) {
		ArrayList<Person> personList = new ArrayList<>();
		
		try {
			// Get file
			File file = new File("src/corejava1/q20/data.txt");
			
			// Use scanner to treat the file as input | NOTE: this will open the file.
			Scanner inputFile = new Scanner(file);
			
			//Iterate through the file
			while(inputFile.hasNext()) {
				// Get line:
				String str = inputFile.nextLine();
				// Split line by ':'
				String [] array = str.split(":");
				
				// Store data to the appropriate variables
				String firstName = array[0];
				String lastName = array[1];
				int age = Integer.parseInt(array[2]);
				String state = array[3];
				
				// Create person
				Person person = new Person(firstName, lastName, age, state);
				personList.add(person);
			}
			
			// close file
			inputFile.close();
			
			// Print the records
			System.out.println(personList);
			
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
