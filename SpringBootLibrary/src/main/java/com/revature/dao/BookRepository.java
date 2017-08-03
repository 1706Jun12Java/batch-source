package com.revature.dao;

import com.revature.Beans.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Integer> {

}
