package question.twenty;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputOutputPrint {

	public static void main(String[] args) {
		String filename = "src/question/twenty/Data.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(filename))){
			String line;
			while ((line = br.readLine()) != null) {
				String[] myArray = line.split(":");
				System.out.println("Name: " + myArray[0] + " " + myArray[1]);
				System.out.println("Age: " + myArray[2] + " years");
				System.out.println("State: " + myArray[3] + " State \n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
