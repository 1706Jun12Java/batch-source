package com.revature.dao;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.Author;
import com.revature.beans.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{

	Iterable<Book> findByAuthor(Author a);

}
