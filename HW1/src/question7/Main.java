package question7;

import java.util.ArrayList;


public class Main
{
    public static void main(String[] args)
    {
        Employee employee1 = new Employee("John", "IT", 1000);
        Employee employee2 = new Employee("Bob", "Sales", 30);
       

        ArrayList<Employee> eList = new ArrayList<>();
        eList.add(employee1);
        eList.add(employee2);
        eList.add(employee3);

        System.out.println("Before comparing: " + eList);

        EmployeeComparator comp = new EmployeeComparator();
        eList.sort(comp);

        System.out.println("After comparing: " + eList);

    }
}