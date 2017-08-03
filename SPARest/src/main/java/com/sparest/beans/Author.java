package com.sparest.beans;

import java.io.Serializable;
import javax.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="AUTHOR")
public class Author implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="authorSequence")
    @SequenceGenerator(allocationSize=1,name="authorSequence",sequenceName="AUTHOR_SEQ")
    @Column(name="AUTHOR_ID")
    private int id;

    @Column(name="AUTHOR_NAME")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {

        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}