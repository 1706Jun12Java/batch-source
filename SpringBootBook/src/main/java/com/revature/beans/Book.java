package com.revature.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BOOK")
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Book(int bookId, String title, Author author, int year) {
		super();
		this.bookId=bookId;
		this.title=title;
		this.author=author;
		this.year=year;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookSeq")
	@SequenceGenerator(allocationSize = 1, name = "bookSeq", sequenceName = "BOOK_SEQ")
	@Column(name = "B_ID")
	private int bookId;
	
	@Column(name="B_TITLE")
	private String title;
	
	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "A_ID")
	private Author author;
	
	@Column(name="B_YEAR")
	private int year;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author=author;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year=year;
	}
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author +", year=" + year + "]";
	}

}
