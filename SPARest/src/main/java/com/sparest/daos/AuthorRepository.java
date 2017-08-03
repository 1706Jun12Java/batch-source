package com.sparest.daos;
import org.springframework.data.repository.CrudRepository;
import com.sparest.beans.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}