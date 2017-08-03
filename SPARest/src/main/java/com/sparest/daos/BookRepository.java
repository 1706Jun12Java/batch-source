package com.sparest.daos;

import org.springframework.data.repository.CrudRepository;
import com.sparest.beans.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
}
