package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Book;
import com.revature.service.LibraryService;

@RestController
@RequestMapping(value="/library")
public class LibraryController {
	
	private LibraryService libraryService;
	
	@Autowired
	public LibraryController(LibraryService libraryService) {
		this.libraryService = libraryService;
	}
	
	@CrossOrigin
	@RequestMapping(value="/all", method= RequestMethod.GET)
	public Iterable<Book> getBooks() {
		return this.libraryService.getAllBooks();
	}

}
