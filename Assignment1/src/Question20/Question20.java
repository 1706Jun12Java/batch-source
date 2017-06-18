package Question20;

import java.io.*;

public class Question20 {

	public static void main(String[] args) {

		try {
			// read data from the file, in a MAC, the full file path is needed.
			// change filename if needed
			BufferedReader read = new BufferedReader(new FileReader("Assignment1/src/Question20/Data.txt"));
			String[] arr = read.readLine().split(":");
			// read values until we hit the end
			while (read.readLine() != null) {
				System.out.println("Name: " + arr[0] + " " + arr[1]);
				System.out.println("Age: " + arr[2] + " years");
				System.out.println("State: " + arr[3]);
			}
			// exceptions to be caught
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
