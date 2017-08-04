package com.revature.springbootdemo.dao;

import com.revature.springbootdemo.beans.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by John on 8/3/2017.
 */
public interface BookRepository extends CrudRepository<Book, Integer>
{
}
