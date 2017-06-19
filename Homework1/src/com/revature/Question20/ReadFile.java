package com.revature.Question20;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;

public class ReadFile {

	
	public static void main(String[] args) {
		String filename="src/com/revature/Question20/Data.txt";
		
		
		readObject(filename);	

	}

	static void readObject(String filename){
		try{
			BufferedReader ois = new BufferedReader(new FileReader(filename));
			LinkedList<Person> temp = new LinkedList();
			while(ois.ready()){
				String[] p = ois.readLine().split(":");
				temp.add(new Person(((p[0]+" " +p[1])),Integer.parseInt(p[2]),p[3]));
			}
			Iterator iter = temp.iterator();
			
			while(iter.hasNext()){
				System.out.println(iter.next().toString());
			}
				
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
}
}


