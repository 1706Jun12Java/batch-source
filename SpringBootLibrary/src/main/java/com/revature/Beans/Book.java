package com.revature.Beans;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Book")
public class Book implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookSeq")
    @SequenceGenerator(allocationSize = 1, name = "bookSeq", sequenceName = "BOOK_SEQ")
    @Column(name = "BOOK_ID")
    private int id;

    @Column(name="TITLE")
    private String title;
    @Column(name ="YEAR")
    private int year;
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "books")
    private List<Author> author;

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public Book(String title, int year, List<Author> author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public Book() {

    }

//    public Book(String title, int year, Author author) {
//        this.title = title;
//        this.year = year;
//        this.author = author;
//    }

    public int getYear() {
        return year;

    }

    public void setYear(int year) {
        this.year = year;
    }

//
//    public Author getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Author author) {
//        this.author = author;
//    }

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

}
