package com.revature.comparisons;

public class Movie implements Comparable<Movie>{
	
	public Movie(int id, String name, int year) {
		super();
		this.id = id;
		this.name = name;
		this.year = year;
	}


	private int id;
	private String name;
	private int year;
	

	public Movie() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", year=" + year + "]";
	}


	@Override
	public int compareTo(Movie o) {
		return this.name.compareTo(o.name);
	}

}
