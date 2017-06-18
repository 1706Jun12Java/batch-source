package com.revature.q20;

import java.io.*;

/*
 * 
 * Q20. Create a notepad file called Data.txt and enter the following: 
Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana
 
Write a program that would read from the file and print it out
 to the screen in the following format:
 
Name: Mickey Mouse
Age: 35 years
State: Arizona State

 * 
 * 
 */
public class Main {

	public static void main(String[] args) {
		String fileName="src/com/revature/q20/Data.txt";
		String[] str;
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String lineRead;
			while ((lineRead = br.readLine()) != null) {
				str = lineRead.split(":");
				System.out.println("Name: "+str[0]+" "+str[1]);
				System.out.println("Age: "+str[2]+" years");
				System.out.println("State: "+str[3]+" State");
				System.out.println();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch( IOException e){
			e.printStackTrace();
		}
		
		
	}
}
