package com.revature.service;

import java.util.List;

import javax.jws.WebService;

import com.revature.exception.LibraryFullException;
import com.revature.model.Book;

//you can also generate a service definition from the WSDL exposed by LibraryService

@WebService
public interface Library {
	
	List<Book> getAllBooks();
	String addBook(Book book) throws LibraryFullException;

}
