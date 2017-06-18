package com.company.Q19;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);

        evenSum(list);
        oddSum(list);
        removePrimeNumber(list);
        System.out.println("Prime number removed " + Arrays.toString(list.toArray()));
    }

    public static void evenSum(ArrayList list){
        int sum = 0, value;
        for (int i = 0; i < list.size(); i++) {
            value = Integer.parseInt(list.get(i).toString());
            if (value % 2 == 0)
                sum += value;
        }

        System.out.println(sum);
    }

    public static void oddSum(ArrayList list){
        int sum = 0, value;
        for (int i = 0; i < list.size(); i++) {
            value = Integer.parseInt(list.get(i).toString());
            if (value % 2 != 0)
                sum += value;
        }

        System.out.println(sum);
    }

    public static void removePrimeNumber(ArrayList list){
        int value;
        for (int i = 0; i < list.size(); i++) {
            value = Integer.parseInt(list.get(i).toString());
            if (checkPrime(value)) {
                list.remove(i);
            }
        }
    }

    public static boolean checkPrime(int value){
        if (value < 2)
            return false;

        for(int i = 2; i <= value/2; i++){
            if (value % i == 0)
                return false;
        }

        return true;
    }
}
