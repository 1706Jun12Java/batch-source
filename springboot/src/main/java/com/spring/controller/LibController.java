package com.spring.controller;

import com.spring.bean.Author;
import com.spring.service.LibService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/lib")
public class LibController {

    private LibService libService;

    @Autowired
    public LibController(LibService libService){
        this.libService = libService;
    }

    @RequestMapping(value="/all", method= RequestMethod.GET)
    public Iterable<Author> getAuthor(){
        return this.libService.getAllAuthor();
    }
}
