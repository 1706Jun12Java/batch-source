package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.*;
import com.revature.service.*;

@RestController
@RequestMapping(value="/lib")
public class LibController {
	
	private LibService libService;
	
	@Autowired
	public LibController(LibService libService){
		this.libService = libService;
		Author a = new Author("fname","lname");
		libService.addAuthor(a);
		Book b = new Book("Hello world",1990);
		
		libService.addBook(b);
		
	}
	@RequestMapping(value="/author/all",method=RequestMethod.GET)
	public Iterable<Author> getAllAuthors(){
		return this.libService.getAllAuthors();
	}
	
	@RequestMapping(value="/author/{id}",method=RequestMethod.GET)
	public Author getBatById(@PathVariable("id") int id){
		return this.libService.getAuthor(id);
	}
	@RequestMapping(value="/book/all",method=RequestMethod.GET)
	public Iterable<Book> getAllBooks(){
		return this.libService.getAllBooks();
	}

}
