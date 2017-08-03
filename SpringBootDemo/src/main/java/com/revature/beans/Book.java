package com.revature.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "BOOKS")
public class Book implements Serializable {

	public Book() {
		super();
	}

	public Book(String name, int year, Author author) {
		super();
		this.name = name;
		this.year = year;
		this.author = author;
	}

	private static final long serialVersionUID = 2101899199719294186L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookSeq")
	@SequenceGenerator(allocationSize = 1, name = "bookSeq", sequenceName = "BOOK_SEQ")
	@Column(name = "BOOK_ID")
	private int id;

	@Column(name = "BOOK_TITLE")
	private String name;

	@Column(name = "BOOK_YEAR")
	private int year;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AUTHOR_ID")
	private Author author;

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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", year=" + year + ", author=" + author + "]";
	}

}
