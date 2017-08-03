package com.spring.dao;

import com.spring.bean.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Integer>{
}
