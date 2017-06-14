package question20;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileParser {
	
	public static void main(String[] args){
		File f = new File("Data.txt");
		String temp = "";
		try {
			Scanner sc = new Scanner(f);
			while(sc.hasNextLine()){
				temp = sc.nextLine();
				String[] array = temp.split(":");
				String name = "Name: " +array[0] + " " + array[1];
				String age ="";
				if(Integer.parseInt(array[2])<=1){
					 age ="Age: "+ array[2] + " year";
				}else{
					 age = "Age: "+array[2] + " years";
				}
				String state = "State: " + array[3]+ " State";
				System.out.println(name+"\n"+age+"\n"+state+"\n");
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found.");
			e.printStackTrace();
		}

	}
}
