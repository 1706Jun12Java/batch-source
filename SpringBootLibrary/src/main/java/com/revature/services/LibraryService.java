package com.revature.services;


import com.revature.Beans.Author;
import com.revature.Beans.Book;
import com.revature.dao.AuthorRepository;
import com.revature.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class LibraryService {

    private BookRepository bookRepository;

    private AuthorRepository authorRepository;

    @Autowired
    public LibraryService(BookRepository bookRepository, AuthorRepository authorRepository){
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public Iterable<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    public Book getBook(int i){
        Book b = this.bookRepository.findOne(i);
        return b;
    }

    public Iterable<Author> getAllAuthors(){
        return this.authorRepository.findAll();
    }

    public Author getAuthor(int i){
        Author b = this.authorRepository.findOne(i);
        return b;
    }
    public long getCount(){
        return this.bookRepository.count();
    }
    public void createAuthor(Author a){
        this.authorRepository.save(a);
    }
    public void createBook(Book b){
        this.bookRepository.save(b);
    }
}
