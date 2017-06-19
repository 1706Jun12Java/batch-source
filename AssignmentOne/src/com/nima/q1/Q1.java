package com.nima.q1;

public class Q1 {
    
    
    public static void main(String[] args) {
        int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
        int temp = 0;
        //nested for-loops to traverse and sort the array
        for(int i=0; i < arr.length; i++){
            for(int j=1; j < (arr.length-i); j++){
                if(arr[j-1] > arr[j]){
                    //swap the values
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        //print the array on screen
        for(int a=0;a<arr.length;a++){
            System.out.print(arr[a]+" ");
        }
    }
}
