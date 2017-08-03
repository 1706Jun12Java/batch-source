package com.revature.dao;

import org.springframework.data.repository.CrudRepository;

import com.revature.beans.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer>{

}
