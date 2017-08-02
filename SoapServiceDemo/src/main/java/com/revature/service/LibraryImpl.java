package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import com.revature.exception.LibraryFullException;
import com.revature.model.Book;

@WebService(endpointInterface="com.revature.service.Library")
public class LibraryImpl implements Library {
	@Override
	public List<Book> getAllBooks() {
		System.out.println("getAllBooks");
		List<Book> bookList = new ArrayList<>();
		//we should be getting books from a backend, but we're not. 
		bookList.add(new Book("The Word Eater","Mary Amato",2000));
		bookList.add(new Book("The World Eater","Robert Swindells",1981)); //3.2/5
		bookList.add(new Book("To Kill a Mockingbird","Harper Lee",1960));
		return bookList;
	}

	@Override
	public String addBook(Book book) throws LibraryFullException {
		System.out.println("add book: "+book);
		if (book.getYear() == 1999){
			throw new LibraryFullException("Library full. Cannot add book: "+book);
		}
		return "successfully added book with title: "+book.getTitle();
	}

}
