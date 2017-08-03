package com.revature.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.beans.Author;
import com.revature.dao.AuthorRepository;

@Component
@Transactional
public class AuthorService {
	
private AuthorRepository ar;
	
	@Autowired
	public AuthorService(AuthorRepository ar){
		this.ar = ar;
	}
	
	public Iterable<Author> getAllAuthors(){
		return this.ar.findAll();
	}
	
}
