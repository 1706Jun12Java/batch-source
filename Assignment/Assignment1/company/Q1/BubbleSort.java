package com.company.Q1;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args){
        int arr[] = {1,0,5,6,3,2,3,7,9,8,4};

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr){
        int temp;

        for (int i = arr.length - 1; i >= 0; i--){
            for (int j = 0; j < i; j++){
                if (arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
