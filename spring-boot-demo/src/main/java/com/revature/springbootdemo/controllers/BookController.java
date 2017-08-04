package com.revature.springbootdemo.controllers;

import com.revature.springbootdemo.beans.Book;
import com.revature.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by John on 8/3/2017.
 */
@RestController
public class BookController
{
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/book/all", method = RequestMethod.GET)
    public List<Book> getAllBooks()
    {
        return bookService.getAll();
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public Book getBookById(int id)
    {
        return bookService.getById(id);
    }
}
