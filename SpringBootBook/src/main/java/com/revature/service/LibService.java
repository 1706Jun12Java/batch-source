package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Author;
import com.revature.beans.Book;
import com.revature.dao.*;

@Component
@Transactional
public class LibService {

	//Spring boot will autowire your dependencies 
		private BookRepo bookRepo;
		private AuthorRepo authorRepo;
		
		@Autowired
		public LibService(BookRepo bookRepo, AuthorRepo authorRepo){
			this.bookRepo = bookRepo;
			this.authorRepo=authorRepo;
		}
		
		public Iterable<Book> getAllBooks(){
			return this.bookRepo.findAll();
		}
		public Iterable<Author> getAllAuthors(){
			return this.authorRepo.findAll();
		}
		
		public Book getBook(int i){
			Book b = this.bookRepo.findOne(i);
			return b;
		}
		public Author getAuthor(int i){
			Author b = this.authorRepo.findOne(i);
			return b;
		}
		
		public void addAuthor(Author a) {
			this.authorRepo.save(a);
		}
		
		
		
		public void addBook(Book a) {
			this.bookRepo.save(a);
		}

}
