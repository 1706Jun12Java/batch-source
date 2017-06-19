package com.revature.mutations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class DriverClass {

	public static void main(String[] args) {
		String csvFile = "..//MinimumMutations//src//com//revature//mutations//File.txt";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ":";
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                String[] geneInfo = line.split(cvsSplitBy);
                System.out.println("start: " + geneInfo[0]);
                System.out.println("end: " + geneInfo[1]);
                System.out.println("bank: " + geneInfo[2] + "," + geneInfo[3] + "," + geneInfo[4]);
                
                UtilityClass us = new UtilityClass(geneInfo[0],geneInfo[1]);
                if((us.checkSame(geneInfo[0],geneInfo[1])== 0)){
                	System.out.println("The start and end are the same.");	
                	}
                else {
                
            		int count = 0; 
                	char[] c1 = geneInfo[0].toCharArray(); 
                	char[] c2 = geneInfo[1].toCharArray(); 
                	for(int i=0;i<8;i++){
                		if (c1[i] != c2[i]){
                			count += 1; 
                		}
                	}
                	System.out.println("Number of mutations needed: " + count);
              
                	System.out.println(us.numberOfMutations(count));
            		
                }
                System.out.println("");

            }
                

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		

	}

}
