package com.spring.service;

import com.spring.bean.Author;
import com.spring.bean.Book;
import com.spring.dao.AuthorRepo;
import com.spring.dao.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class LibService {
    private AuthorRepo authorRepo;
    private BookRepo bookRepo;

    @Autowired
    public LibService(AuthorRepo authorRepo, BookRepo bookRepo) { this.authorRepo = authorRepo; this.bookRepo = bookRepo; }

    public Iterable<Author> getAllAuthor() { return this.authorRepo.findAll(); }
    public Iterable<Book> getAllBook() { return this.bookRepo.findAll(); }

    public Author getAuthor(int i){
        Author author = this.authorRepo.findOne(i);
        return author;
    }

    public long getCount(){
        return this.authorRepo.count();
    }

    public void saveAuthor(Author author){
        this.authorRepo.save(author);
    }

    public void saveBook(Book book){
        this.bookRepo.save(book);
    }

}
