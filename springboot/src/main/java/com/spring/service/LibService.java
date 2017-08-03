package com.spring.service;

import com.spring.bean.Author;
import com.spring.dao.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class LibService {
    private AuthorRepo authorRepo;

    @Autowired
    public LibService(AuthorRepo authorRepo) { this.authorRepo = authorRepo; }

    public Iterable<Author> getAllAuthor() { return this.authorRepo.findAll(); }

    public Author getAuthor(int i){
        Author author = this.authorRepo.findOne(i);
        return author;
    }

    public long getCount(){
        return this.authorRepo.count();
    }

}
