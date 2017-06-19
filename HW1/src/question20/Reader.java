package question20;

import java.io.*;

public class Reader {

	public static void main(String[] args) {
		
		String filename = "eclipse-workspace/HW1/src/question20/Data.txt";
		getLines(filename);
	}
	
	public static String getLines(String filename){
		try{
			BufferedReader fil = new BufferedReader(new FileReader(filename));
			String line;
			while((line=fil.readLine())!=null){
				String[] ary = line.split(":");
				System.out.println("Name: "+ary[0]+" "+ary[1]);
				System.out.println("Age: "+ary[2]+ " years");
				System.out.println("State: "+ary[3]+ " state");
				System.out.println();
			}
			fil.close();
		} catch(FileNotFoundException e){
			System.out.println("File not found!");
		} catch(IOException e){
			System.out.println("IO exception!");
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

}