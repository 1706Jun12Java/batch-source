package com.company.Q13;

public class Triangle {

    public static void main(String[] args) {
//        0
//        1 0
//        1 0 1
//        0 1 0 1

        trianglePrint(4);


    }

    public static void trianglePrint(int length){
        boolean check = false;
        for (int i = 0; i < length; i++){
            for (int j = 0; j <= i; j++){
                if(!check){
                    check = true;
                    System.out.print("0 ");
                    continue;
                }
                check = false;
                System.out.print("1 ");
            }
            System.out.println("");
        }
    }


}
