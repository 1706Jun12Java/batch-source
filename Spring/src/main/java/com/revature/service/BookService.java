package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Book;
import com.revature.dao.BookRepository;

@Component
@Transactional
public class BookService {

	private BookRepository br;
	
	@Autowired
	public BookService(BookRepository br){
		this.br = br;
	}
	
	public Iterable<Book> getAllBooks(){
		return this.br.findAll();
	}
	
	public Book getBook(int i){
		Book b = this.br.findOne(i);
		return b;
	}
	
	public Book addBook(Book b){
		return this.br.save(b);
	}
	
	public long getCount(){
		return this.br.count();
	}
}
