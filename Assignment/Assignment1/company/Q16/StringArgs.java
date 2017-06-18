package com.company.Q16;

public class StringArgs {
    public static void main(String[] args) {

        int argsLength = 0;
        for(int i=0;i< args.length;i++){
            for (int j = 0; j < args[i].length(); j++)
                argsLength++;
        }

        System.out.println(argsLength);
    }
}
