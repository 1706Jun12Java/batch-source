package com.revature.springbootdemo.service;

import com.revature.springbootdemo.beans.Book;
import com.revature.springbootdemo.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by John on 8/3/2017.
 */

@Component
@Transactional
public class BookService
{
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAll()
    {
        return (List<Book>) bookRepository.findAll();
    }

    public Book getById(int id)
    {
        return bookRepository.findOne(id);
    }
}
