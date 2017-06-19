package q20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Create a notepad file called Data.txt and enter the following: 
//Mickey:Mouse:35:Arizona
//Hulk:Hogan:50:Virginia
//Roger:Rabbit:22:California
//Wonder:Woman:18:Montana
//Write a program that would read from the file and print 
//it out to the screen in the following format:
//Name: Mickey Mouse
//Age: 35 years
//State: Arizona State
public class ReadingFromFile {

	public static void main(String[] args) {
		
		try {
			
			FileReader fr = new FileReader("Data.txt");
			BufferedReader br = new BufferedReader(fr);
			String info;
			
			while ((info = br.readLine()) != null) {
				
				String[] person = info.split(":");
				System.out.println("Name: " + person[0] + " " + person[1]);
				System.out.println("Age: " + person[2] + " years");
				System.out.println("State: " + person[3] + " state");
				System.out.println();
			}
			
			br.close();
		} catch (IOException e) {
			System.out.println("File not found.");
		}
	}
}
