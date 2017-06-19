/* Q20. Create a notepad file called Data.txt and enter the following:
Mickey:Mouse:35:Arizona
Hulk:Hogan:50:Virginia
Roger:Rabbit:22:California
Wonder:Woman:18:Montana

Write a program that would read from the file and print it out to the screen in the
following format:
Name: Mickey Mouse
Age: 35 years
State: Arizona Statepackage com.FileIO;
*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
public class FileInputOutput {

	public static void main(String[] args)throws IOException{
		String s = new String(Files.readAllBytes(Paths.get("testing.txt")));
		System.out.print(s); 
		readObject(s);
    }
	
	static void readObject(String filename){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			Object obj = ois.readObject();
			System.out.println("Read object: "+obj.toString());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
