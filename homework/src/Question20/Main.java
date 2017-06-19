package Question20;

import java.io.*;

public class Main {
	
	public static void main(String[] args) {
		//create buffered reader to look for file to read
		try {
			BufferedReader reader = new BufferedReader(new FileReader("homework/src/Question20/Data.txt"));
			String[] str = reader.readLine().split(":");
			// read values
			while (reader.readLine() != null) {
				System.out.println("Name: " + str[0] + " " + str[1]);
				System.out.println("Age: " + str[2] + " years");
				System.out.println("State: " + str[3]);
				reader.close();
}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException i){
			i.printStackTrace();
		}
	}

}
