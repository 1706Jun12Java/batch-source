package com.sparest.services;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.sparest.beans.*;
import com.sparest.daos.*;

@Component
@Transactional
public class LibraryService {
    private AuthorRepository a;
    private BookRepository b;

    @Autowired
    public LibraryService(AuthorRepository a, BookRepository b) { this.a = a; this.b = b; }

    public Iterable<Author> getAllAuthor() { return this.a.findAll(); }
    public Iterable<Book> getAllBook() { return this.b.findAll(); }

    public Author getAuthor(int i){
        Author author = this.a.findOne(i);
        return author;
    }

    public long getCount(){
        return this.a.count();
    }

    public void saveAuthor(Author author){
        this.a.save(author);
    }

    public void saveBook(Book book){
        this.b.save(book);
    }

}