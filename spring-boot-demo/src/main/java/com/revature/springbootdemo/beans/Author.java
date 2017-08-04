package com.revature.springbootdemo.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

/**
 * Created by John on 8/3/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
@Entity
@Table(name = "Author")
public class Author
{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> book;

    public Author()
    {
    }

    public Author(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString()
    {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
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

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public List<Book> getBook()
    {
        return book;
    }

    public void setBook(List<Book> book)
    {
        this.book = book;
    }
}
