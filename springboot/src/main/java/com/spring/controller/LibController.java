package com.spring.controller;

import com.spring.bean.Author;
import com.spring.bean.Book;
import com.spring.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/lib")
public class LibController {

    private LibService libService;

    @Autowired
    public LibController(LibService libService){
        this.libService = libService;
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public Iterable<Book> getAuthor(){
//        Author author = new Author("author1");
//        Author author1 = new Author("author2");
//
//        this.libService.saveAuthor(author);
//        this.libService.saveAuthor(author1);
//
//        Book book = new Book("book", author);
//        Book book1 = new Book("book1", author1);
//
//        Author author2 = new Author(1);
//        Book book2 = new Book("book2", author2);
//
//        this.libService.saveBook(book);
//        this.libService.saveBook(book1);
//        this.libService.saveBook(book2);

        return this.libService.getAllBook();
    }

}
