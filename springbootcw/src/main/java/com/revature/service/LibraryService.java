package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Author;
import com.revature.beans.Book;
import com.revature.dao.AuthorRepository;
import com.revature.dao.BookRepository;

@Component
@Transactional
public class LibraryService {
	private BookRepository bookRepo;
	private AuthorRepository authorRepo;

	//Spring boot will autowire your dependencies 
	
	@Autowired
	public LibraryService(AuthorRepository authorRepo, BookRepository bookRepo){
		this.authorRepo = authorRepo;
		this.bookRepo = bookRepo;
	}
	
	public Iterable<Author> getAllAuthors(){
		return this.authorRepo.findAll();
	}
	
	public Iterable<Book> getAllBooks(){
		return this.bookRepo.findAll();
	}
	
	public Author getAuthor(int i){
		Author a = this.authorRepo.findOne(i);
		return a;
	}
	
	public void saveAuthor(Author a) {
		this.authorRepo.save(a);
	}
	
	public void saveBook(Book b) {
		this.bookRepo.save(b);
	}
	
	public long getAuthorCount(){
		return this.authorRepo.count();
	}
}