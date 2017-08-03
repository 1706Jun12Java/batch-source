package com.spring.bean;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

@Component
@Entity
@Table(name="AUTHOR")
public class Author implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="authorSequence")
    @SequenceGenerator(allocationSize=1,name="authorSequence",sequenceName="AUTHOR_SEQ")
    @Column(name="AUTHOR_ID")
    private int id;

    @Column(name="AUTHOR_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name="BOOK_ID")
    private Book book;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Book getBook() {
        return book;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author(String name, Book book) {

        this.name = name;
        this.book = book;
    }

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
