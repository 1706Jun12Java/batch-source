package Question7;

import java.util.ArrayList;

/**
 * Created by John on 6/16/2017.
 */
public class ComparatorExample
{
    public static void main(String[] args)
    {
        Employee employee1 = new Employee("John", "IT", 1000);
        Employee employee2 = new Employee("Bob", "Sales", 30);
        Employee employee3 = new Employee("karen", "Marketing", 23);

        ArrayList<Employee> eList = new ArrayList<>();
        eList.add(employee1);
        eList.add(employee2);
        eList.add(employee3);

        System.out.println("Before comparing: " + eList);

        EmployeeComparator comparator = new EmployeeComparator();
        eList.sort(comparator);

        System.out.println("After comparing: " + eList);

    }
}
