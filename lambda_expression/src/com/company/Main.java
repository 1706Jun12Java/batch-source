package com.company;

public class Main {

    interface PerformOperation {
        boolean operation(int a);
    }
    public boolean operateBinary(int a, PerformOperation op) {
        return op.operation(a);
    }
    public static void main(String[] args) {
        PerformOperation isOdd = (int a) -> {
            if (a % 2 == 0)
                return false;
            return true;
        };

        PerformOperation isPrime = (int a) -> {
            return true;
        };

        PerformOperation isPalindrome = (int a) ->{
            String string = Integer.toString(a);

            for (int i = 0; i < string.length() /2; i++){
                char front = string.charAt(i);
                char end = string.charAt(string.length() - 1 - i);
                if (front != end)
                    return false;
            }
            return true;
        };


        Main main = new Main();

        System.out.println(main.operateBinary(39,isOdd));

        System.out.println(main.operateBinary(10101,isPalindrome));
    }
}

