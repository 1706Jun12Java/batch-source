package com.revature.comparisons;

import java.util.*;

public class CompareExample {

	public static void main(String[] args) {
		
		ArrayList<Movie> list = new ArrayList<>();
		list.add(new Movie(10,"Wall-E",2008));
		list.add(new Movie(11,"Up",2009));
		list.add(new Movie(2,"A New Hope",1977));
		
		/*
		Collections.sort(list);
		System.out.println("movies after sort with Comparable: ");
		for (Movie m : list){
			System.out.println(m.getName());
		}
		
		*/
		NameCompare nameCompare = new NameCompare();
		Collections.sort(list,nameCompare);
		System.out.println("movies after sort with Comparator: ");
		for (Movie m : list){
			System.out.println(m.getName());
		}
		
	}

}
