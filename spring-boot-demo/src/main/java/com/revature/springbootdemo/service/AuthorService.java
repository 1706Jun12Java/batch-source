package com.revature.springbootdemo.service;

import com.revature.springbootdemo.beans.Author;
import com.revature.springbootdemo.dao.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by John on 8/3/2017.
 */
@Component
@Transactional
public class AuthorService
{
    private AuthorRepository authorDao;

    @Autowired
    public AuthorService(AuthorRepository authorDao)
    {
        this.authorDao = authorDao;
    }

    public List<Author> getAllAuthors()
    {
        return (List<Author>) authorDao.findAll();
    }

    public Author getById(int id)
    {
        return authorDao.findOne(id);
    }

    public void saveAuthor(Author author)
    {
        authorDao.save(author);
    }
}
