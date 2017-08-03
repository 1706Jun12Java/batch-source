package com.revature.beans;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BOOK")
public class Book implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3588151031179726949L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookSeq")
	@SequenceGenerator(allocationSize = 1, name = "bookSeq", sequenceName = "BOOK_SEQ")
	@Column(name = "B_ID")
	private int id;
	
	@Column(name="TITLE")
	private String title;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="A_ID")
	private Author author;
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", yearPublished=" + yearPublished + "]";
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	@Column(name="YEAR")
	private int yearPublished;
}
