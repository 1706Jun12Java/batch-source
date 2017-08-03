package com.revature.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="B_BOOK")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9132140974610228249L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bookSeq")
	@SequenceGenerator(allocationSize=1,name="bookSeq",sequenceName="BOOKz_SEQ")
	@Column(name="BOOK_ID")
	private int id;
	
	@Column(name="TITLE")
	private String title;
	
	
	
	@Column(name="YEAR_PUBLISHED")
	private int yearPublished;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, int yearPublished) {
		super();
		this.title = title;
		this.yearPublished = yearPublished;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", yearPublished=" + yearPublished + "]";
	}
	@ManyToMany(cascade=CascadeType.ALL)
    List<Author> authors;

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}
	public void addAuthor(Author b) {
		authors.add(b);
	}
}
