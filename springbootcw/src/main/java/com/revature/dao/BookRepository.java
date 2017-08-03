package com.revature.dao;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}
