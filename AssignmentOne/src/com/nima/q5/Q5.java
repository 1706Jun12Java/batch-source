package com.nima.q5;

public class Q5 {
	
/*
 Q5. Write a substring method that accepts a string str and an integer idx and returns
  the substring contained between 0 and idx-1 inclusive. 
  Do NOT use any of the existing substring methods in the String, 
  StringBuilder, or StringBuffer APIs.
 */

public static void main(String[] args){
        
        String str = "This is a test string";
        int idx = 5;    //position to get the sub string
        System.out.println(substring(str,idx)); //return and print the result
        
    }
    public static String substring(String str, int idx){
        
        String temp = "";   //variable to save the sub string
        for(int a=0;a<str.length();a++){//loop to get the sub string
            //after the required position, add the whole string to the temp varialbe
            if(a>=idx){
                temp += str.charAt(a);
            }
        }
        //return the result
        return temp;
    }
    
}
