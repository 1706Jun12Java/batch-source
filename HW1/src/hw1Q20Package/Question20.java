package hw1Q20Package;

import java.io.*;

public class Question20 {

	public static void main(String[] args) {
		String fileName = "src/hw1Q20Package/Data.txt";
		BufferedReader in = null;
		try{
			in = new BufferedReader(new FileReader(fileName));
			String read = null;
			while((read = in.readLine()) != null){
				String[] splitString = read.split(":");
				for(String i:splitString){
					System.out.println(i);
				}
			}
		}catch(IOException e){
			System.out.println("Error" + e);
			e.printStackTrace();
		}
	}

}
