package com.company.Q20;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        String fileName = "src/com/company/Q20/Data.txt";
        readFile(fileName);
    }

    public static void readFile(String fileName) throws Exception {
        try (InputStream is = new FileInputStream(fileName)){
            BufferedReader buf = new BufferedReader(new InputStreamReader(is));

            String line = buf.readLine();
            ArrayList list = new ArrayList<>();

            while(line != null){
                list.add(line);
                line = buf.readLine();
            }

            for (int i = 0; i < list.size(); i++) {
                outputString(list.get(i).toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void outputString(String string){
        String[] splitString = string.split(":");

        if (splitString.length != 4)
            return;

        String name = splitString[0] + " " + splitString[1];
        String age = splitString[2];
        String state = splitString[3];

        System.out.println("Name: " + name + "\n"
                            + "Age: " + age + " years\n"
                            + "State: " + state + " State\n");
    }
}
