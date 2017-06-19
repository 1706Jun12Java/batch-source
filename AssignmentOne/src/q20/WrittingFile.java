package q20;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WrittingFile {

	public static void main(String[] args) {
		
		try{
			FileWriter fw = new FileWriter("Data.txt");
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("Mickey:Mouse:35:Arizona");
			pw.println("Hulk:Hogan:50:Virginia");
			pw.println("Roger:Rabbit:22:California");
			pw.println("Wonder:Woman:18:Montana");
			
			pw.close();
		} catch(IOException e){
			System.out.println("ERROR");
		}
	}

}
