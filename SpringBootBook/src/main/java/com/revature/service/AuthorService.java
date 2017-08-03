package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Author;
import com.revature.dao.AuthorRepository;

@Component
@Transactional
public class AuthorService {
	
	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorService(AuthorRepository authorRepository){
		this.authorRepository = authorRepository;
	}
	
	public Iterable<Author> getAllAuthors(){
		return this.authorRepository.findAll();
	}
	
	public Author getAuthor(int i){
		Author a = this.authorRepository.findOne(i);
		return a;
	}
	
	public long getCount(){
		return this.authorRepository.count();
	}
}
