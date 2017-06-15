package com.revature.comparisons;

import java.util.Comparator;

public class NameCompare implements Comparator<Movie> {

	public NameCompare() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Movie arg0, Movie arg1) {
		return arg0.getName().compareTo(arg1.getName());
	}

}
