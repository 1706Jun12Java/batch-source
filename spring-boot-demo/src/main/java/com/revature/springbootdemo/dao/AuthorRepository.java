package com.revature.springbootdemo.dao;

import com.revature.springbootdemo.beans.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by John on 8/3/2017.
 */
public interface AuthorRepository extends CrudRepository<Author, Integer>
{
}
