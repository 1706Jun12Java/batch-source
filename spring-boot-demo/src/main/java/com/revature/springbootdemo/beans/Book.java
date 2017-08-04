package com.revature.springbootdemo.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by John on 8/3/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@Entity
@Table(name = "Book")
public class Book
{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    public Book()
    {
    }

    public Book(String title, Author author, String year)
    {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", year='" + year + '\'' +
                '}';
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year)
    {
        this.year = year;
    }

    private String year;

    public Author getAuthor()
    {
        return author;
    }

    public void setAuthor(Author author)
    {
        this.author = author;
    }
}
