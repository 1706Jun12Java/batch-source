package com.nima.q11a;

import com.nima.q11b.Q11b;

public class Q11a {
    
    
    public static void main (String[]args){
        
        //Create object of some other class in some other package
        Q11b obj = new Q11b();
        //access their float variables and print them.
        System.out.println(obj.number1+" "+obj.number2);
    }
    
}