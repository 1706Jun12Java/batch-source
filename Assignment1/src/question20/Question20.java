package question20;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Question20 {
	static String convertToString(ArrayList<String> numbers) {
        StringBuilder builder = new StringBuilder();
        // Append all Integers in StringBuilder to the StringBuilder.
        for (String num1 : numbers) {
            builder.append(num1);
            builder.append(":");
        }
        // Remove last delimiter with setLength.
        builder.setLength(builder.length() - 1);
        return builder.toString();
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// The name of the file to open.
		ArrayList<String> num = new ArrayList<String>();
		
        String fileName = "/Users/bchoi/Documents/workspace-sts-3.8.4.RELEASE/Assignment1/src/question20/Data.txt";
       // String content = new String(Files.readAllBytes(Paths.get(fileName)));
        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                num.add(line);
                List<String> lines = Files.readAllLines(Paths.get(fileName));
                System.out.println(lines);
            }   
            

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
       
        
        
        
    }


	}


