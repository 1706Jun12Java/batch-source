package question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;;

public class Question7 {

	public static void main(String[] args) {

		ArrayList<Object> ee = new ArrayList<>();

		ee.add(new Employee("Bob", 20, "Sales"));
		ee.add(new Employee("Emily", 26, "Human Resource"));
		ee.add(new Employee("Tim", 28, "Technology"));
		ee.add(new Employee("Karl", 23, "Sales"));
		ee.add(new Employee("Sam", 20, "Accounting"));

		System.out.println("Sorting by Name...");

		Collections.sort(ee, new NameComparator<>());
		Iterator<Object> itr = ee.iterator();
		while (itr.hasNext()) {
			Employee eee = (Employee) itr.next();
			System.out.println(eee.name + " " + eee.age + " " + eee.deparment);
		}
		System.out.println("Sorting by Age...");

			Collections.sort(ee, new AgeComparator<>());
			Iterator<Object> itr2 = ee.iterator();
			while (itr2.hasNext()) {
				Employee eee1 = (Employee) itr2.next();
				System.out.println(eee1.name + " " + eee1.age + " " + eee1.deparment);

			}
			System.out.println("Sorting by Department...");

			Collections.sort(ee, new DepartmentComparator<>());
			Iterator<Object> itr3 = ee.iterator();
			while (itr3.hasNext()) {
				Employee eee1 = (Employee) itr3.next();
				System.out.println(eee1.name + " " + eee1.age + " " + eee1.deparment);

			}
		}

	}

