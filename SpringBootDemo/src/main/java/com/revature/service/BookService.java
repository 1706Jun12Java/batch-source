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
public class BookService {

	@Autowired
	public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
		super();
		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;

	public Iterable<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}

	public void addAuthor(Author author) {
		authorRepository.save(author);
	}

	public Author getAuthorById(int id) {
		return authorRepository.findOne(id);
	}
}
