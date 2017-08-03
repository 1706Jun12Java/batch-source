package com.revature.dao;

import com.revature.Beans.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {

}
