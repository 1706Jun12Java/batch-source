package Q20;

import java.io.*;
import java.util.*;

public class solution {

//	Create a notepad file called Data.txt and enter the following: 
//		Mickey:Mouse:35:Arizona
//		Hulk:Hogan:50:Virginia
//		Roger:Rabbit:22:California
//		Wonder:Woman:18:Montana
//		 
//		Write a program that would read from the file and print it out to the screen in the following format:
//		 
//		Name: Mickey Mouse
//		Age: 35 years
//		State: Arizona State

		
	public static void main(String[] args) {
		String filename = "src/Q20/Data.txt";
		List<Person> aList = new ArrayList<>(); 
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
		    String line;
		    while ((line = br.readLine()) != null) { 
		       String[] lineArray = line.split(":");
		       aList.add(new Person(lineArray));
		    }
		} catch (IOException e) {
			 
			e.printStackTrace();
		} 
		
		for (Person a: aList){
			System.out.println(a);
			System.out.println();
		}
		
	} 
}

class Person{
	public String Name;
	public int Age;
	public String State;
	
	public Person(String[] info){
		this.Name = info[0] + " " + info[1];
		this.Age = Integer.parseInt(info[2]);
		this.State = info[3];
	}
	
	@Override
	public String toString(){
		return "Name: "+ this.Name +"\nAge: "+this.Age+" years \nState: "+this.State+" State";
	}
}
