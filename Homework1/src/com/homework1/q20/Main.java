package com.homework1.q20;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filename = "src/com/homework1/q20/Data.txt";
		getLines(filename);
	}
	
	public static String getLines(String filename){
		try{
			BufferedReader fIn = new BufferedReader(new FileReader(filename));
			String line;
			while((line=fIn.readLine())!=null){
				String[] ary = line.split(":");
				System.out.println("Name: "+ary[0]+" "+ary[1]);
				System.out.println("Age: "+ary[2]+ " years");
				System.out.println("State: "+ary[3]+ " state");
				System.out.println();
			}
			fIn.close();
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
