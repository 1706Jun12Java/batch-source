package com.revature.model;

public class Book {
	public Book(int bid, String title, int author, int year) {
		super();
		this.bid = bid;
		this.title = title;
		this.author = author;
		this.year = year;
	}
	public Book() {
		super();
	}
	private int bid;
	private String title;
	private int author;
	private int year;
	
	public int getBid(){
		return bid;
	}
	public void setBid(int bid){
		this.bid = bid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAuthor() {
		return author;
	}
	public void setAuthor(int author) {
		this.author = author;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", title=" + title + ", author=" + author + ", year=" + year + "]";
	}

}

