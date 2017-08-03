package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Author;
import com.revature.service.AuthorService;

@RestController
@RequestMapping(value="/author")
public class AuthorController {
	
	private AuthorService authorService;
	
	@Autowired
	public AuthorController(AuthorService authorService){
		this.authorService = authorService;
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public Iterable<Author> getAllBooks(){
		return this.authorService.getAllAuthors();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Author getAuthorById(@PathVariable("id") int id){
		return this.authorService.getAuthor(id);
	}
}
