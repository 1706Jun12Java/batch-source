package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Author;
import com.revature.beans.Book;
import com.revature.service.BookService;

@RestController
@CrossOrigin
@RequestMapping("/book")
public class HelloController {

	@Autowired
	public HelloController(BookService bookService) {
		super();
		this.bookService = bookService;
	}

	private BookService bookService;

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public Iterable<Book> getAll() {
		return bookService.getAllBooks();
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.GET)
	public void addAuthor() {
		Book book = new Book("FireStarter", 1980, bookService.getAuthorById(3));
		bookService.addBook(book);
	}
}
