package com.spring.bean;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
@Table(name="BOOK")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator="bookSequence")
    @SequenceGenerator(allocationSize=1,name="bookSequence",sequenceName="BOOK_SEQ")
    @Column(name="ID")
    private int id;

    @Column(name="BOOK_NAME")
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public Book(){

    }

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
}
