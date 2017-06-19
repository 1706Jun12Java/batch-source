package com.nima.q20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q20 {
    
    public static void main(String args[]) throws IOException{
        //open the file in read mode
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        String line = "";
        //read it line by line
        while((line = br.readLine())!=null){
            String[] record = line.split(":");  //split each line and store values in string array
            //print the values on screen
            System.out.println("Name: "+record[0]+" "+record[1]);
            System.out.println("Age: "+record[2]+" years");
            System.out.println("State: "+record[3]+" state");
            System.out.println("");
        }
        
        
    }
    
}