package com.revature.collections;

import java.util.*;

public class SetExamples {

	public static void main(String[] args) {

		Set<Integer> hashSet = new LinkedHashSet<>();
		hashSet.add(5);
		hashSet.add(5);
		hashSet.add(2);
		hashSet.add(17);

		System.out.println("linked hashSet: " + hashSet);
		System.out.println((hashSet.size()));

		Set<Integer> treeSet = new TreeSet<>();
		treeSet.addAll(hashSet);
		System.out.println("TreeSet: " + treeSet);
	}

}
