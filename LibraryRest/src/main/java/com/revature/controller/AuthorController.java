package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Author;
import com.revature.beans.Book;
import com.revature.service.AuthorService;
import com.revature.service.BookService;

@CrossOrigin
@RestController
@RequestMapping(value="/author")
public class AuthorController {

	private AuthorService authorService;
	
	@Autowired
	public AuthorController(AuthorService authorService){
		this.authorService = authorService;
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Iterable<Author> getAllAuthors(){
		return this.authorService.getAllAuthors();
	}
}
