package com.revature.io;

import java.io.*;

public class Serialize {

	public static void main(String[] args) {
		String filename = "src/serializedThings/PersonDemo";
		Person person = new Person("john",23,"09123408954602310");
		//writeObject(filename,person);
		readObject(filename);

	}
	
	static void writeObject(String filename, Object obj){
		//try with resources
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))){
			oos.writeObject(obj);
			System.out.println("wrote to file: "+obj.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void readObject(String filename){
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
			Object obj = ois.readObject();
			System.out.println("read object: "+obj.toString());
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
