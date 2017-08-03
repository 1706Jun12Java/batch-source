package com.revature.beans;

import java.io.Serializable;

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
public class Book implements Serializable {
	private static final long serialVersionUID = 4317096999125129515L;
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="bookSequence")
	@SequenceGenerator(allocationSize=1,name="bookSequence",sequenceName="BOOK_SEQ")
	@Column(name="BOOK_ID")
	private int id;
	
	@Column(name="BOOK_TITLE")
	private String title;
	
	@ManyToOne
	@JoinColumn(name="AUTHOR_ID")
	private Author authorId;
	
	@Column(name="BOOK_YEAR_PUBLISHED")
	private int yearPublished;
		
	public Book() {
		
	}
	
	public Book(int id, String title, Author authorId, int yearPublished) {
		super();
		this.id = id;
		this.title = title;
		this.authorId = authorId;
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
	public Author getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Author authorId) {
		this.authorId = authorId;
	}
	public int getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", authorId=" + authorId + ", yearPublished=" + yearPublished
				+ "]";
	}
	
	
	
	
	
}


