package com.company.Q7;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        Employee sam = new Employee("sam", "Bank", 23);
        Employee jake = new Employee("jake","sales", 19);

        ArrayList<Employee> list = new ArrayList<>();

        list.add(sam);
        list.add(jake);

        Collections.sort(list, new NameComparator());
        System.out.println("Name Compare");
        for (Employee i: list) {
            System.out.println(i.toString());
        }

        Collections.sort(list, new AgeComparator());
        System.out.println("Age Compare");
        for (Employee i: list) {
            System.out.println(i.toString());
        }

        Collections.sort(list, new DepartmentComparator());
        System.out.println("Department Compare");
        for (Employee i: list) {
            System.out.println(i.toString());
        }
    }
}
