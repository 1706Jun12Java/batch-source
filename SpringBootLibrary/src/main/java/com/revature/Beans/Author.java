package com.revature.Beans;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name="Author")
public class Author implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AuthorSEQ")
    @SequenceGenerator(allocationSize = 1, name = "AuthorSEQ", sequenceName = "AUTHORS_SEQ")
    @Column(name = "AUTHOR_ID")
    private int id;

    @ManyToMany(cascade=CascadeType.ALL)
    private List<Book> books;
    @Column(name="FIRSTNAME")
    private String firstName;
    @Column(name="LASTNAME")
    private String lastName;

    public Author(){}
    public Author(List<Book> books, String firstName, String lastName) {
        this.books = books;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
