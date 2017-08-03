package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Author;
import com.revature.beans.Book;
import com.revature.service.BookService;

@RestController
@RequestMapping(value="/book")
public class BookController {

private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService){
		this.bookService = bookService;
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Iterable<Book> getAllBooks(){
		return this.bookService.getAllBooks();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Book getBookById(@PathVariable("id") int id){
		return this.bookService.getBook(id);
	}
	
	@RequestMapping(value="/byauthor/{id}",method=RequestMethod.GET)
	public Iterable<Book> findByAuthor(@PathVariable("id") Author id){
		return this.bookService.findByAuthor(id);
	}
	
}
