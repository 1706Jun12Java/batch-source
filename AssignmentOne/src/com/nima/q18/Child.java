package com.nima.q18;

public class Child extends Parent{
    //chilc class which implements three methods of parent class
    //below are the three methods implemented
    @Override
    public boolean CheckUppercase(String str) {
        //check if it has an uppercase letter in the string
        boolean hasUppercase = !str.equals(str.toLowerCase());
        return hasUppercase;
    }
    @Override
    public String ConvertLower(String str) {
        //convert an lower case string to upper case and return
        return str.toUpperCase();
    }
    @Override
    public int ConvertToInteger(String str) {
        //fetch number from a string
        int number = Integer.parseInt(str);
        //add 10 to it, and return
        return number+10;
    }
    
    public static void main(String[] args){
        Child obj = new Child();    //create object to access class methods
        //test all three methods and print outputs
        System.out.println(obj.CheckUppercase("Test strnig"));
        System.out.println(obj.ConvertLower("test string"));
        System.out.println(obj.ConvertToInteger("450"));
        
    }
    
}
