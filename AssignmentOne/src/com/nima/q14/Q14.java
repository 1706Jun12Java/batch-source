package com.nima.q14;

import java.util.Date;

public class Q14 {
    
    public static void main(String[] args){
        //choice which will execute the case
        int choice = 3;
        //switch statemetns starts here
        switch(choice){
            case 1: //if the choice is 1
                System.out.println("Square Root: "+Math.sqrt(16));
                break;
            case 2: //if the choice is 2
                Date date = new Date();
                System.out.println(date);
                break;
            case 3: //if the choice is 3
                String str = "I am learning Core Java";
                String[] array = str.split(" ");    //splitting the array
                //display the splitted array string
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i]);
                }
                break;
        }
        
    }
    
}

