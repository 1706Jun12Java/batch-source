package com.nima.q19;

import java.util.ArrayList;

public class Q19 {
    
    public static void main(String[] args){
        //creating and populating array list with number 1-10
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        for(int a=0;a<10;a++){
            list.add(a+1);
        }
        
        //displaying the array list
        for(int a=0;a<list.size();a++){
            System.out.print(list.get(a)+" ");
        }
        //adding even number up
        System.out.println("");
        for(int a=0;a<list.size();a++){
            if(list.get(a)%2 != 0){
                temp.add(a);
            }
        }
        for(int a=0;a<list.size();a++){
            if(list.get(a)%2 == 0){
                temp.add(a);
            }
        }
        //and displaying the result
        for(int a=0;a<temp.size();a++){
            System.out.print(temp.get(a)+" ");
        }
        temp.clear();
        //adding odd number up
        System.out.println("");
        for(int a=0;a<list.size();a++){
            if(list.get(a)%2 == 0){
                temp.add(a);
            }
        }
        for(int a=0;a<list.size();a++){
            if(list.get(a)%2 != 0){
                temp.add(a);
            }
        }
        //and displaying the result
        for(int a=0;a<temp.size();a++){
            System.out.print(temp.get(a)+" ");
        }
        temp.clear();
        //deleting the prime number from array list
        for(int a=0;a<list.size();a++){
            if(isPrime(list.get(a))){
                temp.add(list.get(a));
            }
        }
        //displaying
        System.out.println("");
        for(int a=0;a<temp.size();a++){
            System.out.print(temp.get(a)+" ");
        }
        
    }
    //Method to check if the number is prime or not
    public static boolean isPrime(int number) {
        //check if number is prime
        for(int i=2;i<number;i++) {
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
    
}

