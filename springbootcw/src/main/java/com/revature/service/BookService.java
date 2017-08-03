package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Book;
import com.revature.dao.BookRepository;

@Component
@Transactional
public class BookService {

	//Spring boot will autowire your dependencies 
	private BookRepository bookRepository;
	
	@Autowired
	public BookService(BookRepository bookRepository){
		this.bookRepository = bookRepository;
	}
	
	public Iterable<Book> getAllBooks(){
		return this.bookRepository.findAll();
	}
	
	public Book getBat(int i){
		Book b = this.bookRepository.findOne(i);
		return b;
	}
	
	public long getCount(){
		return this.bookRepository.count();
	}
}