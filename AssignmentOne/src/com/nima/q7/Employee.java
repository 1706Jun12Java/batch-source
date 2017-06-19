package com.nima.q7;

import java.util.ArrayList;

/*
 * Q7. Sort two employees based on their name, 
 * department, and age using the Comparator interface.
 */

public class Employee implements Comparable<Employee>{
    String Name, Dept;
    int Age;
    //constructor to set values
    Employee(String name, String dept, int age){
        Name = name;
        Dept = dept;
        Age = age;
    }
    public static void main(String[] args){
        //creating employee objects
        Employee emp1 = new Employee("James","IT",35);
        Employee emp2 = new Employee("Mike","Food",45);
        ArrayList<Employee> list = new ArrayList<Employee>();
        //comparing the two objects to sort them
        if(emp1.compareTo(emp2)>0){
            //sort and add them to list
            list.add(emp1);
            list.add(emp2);
        }
        else if(emp2.compareTo(emp1)>0){
            //sort and add them to list
            list.add(emp2);
            list.add(emp1);
        }
        //Display results
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }
    //method to compare two objects
    @Override
    public int compareTo(Employee o) {
        return o.Age - this.Age;
    }
    //method to display object values
    public String toString(){
        return Name+" "+Dept+" "+Age;
    }
}