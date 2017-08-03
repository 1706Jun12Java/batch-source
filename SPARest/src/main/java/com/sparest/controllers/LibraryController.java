package com.sparest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sparest.beans.Book;
import com.sparest.services.LibraryService;

@RestController
@RequestMapping(value="/library")
public class LibraryController {

    private LibraryService l;

    @Autowired
    public LibraryController(LibraryService l){
        this.l = l;
    }

    @CrossOrigin
    @RequestMapping(value="/all", method= RequestMethod.GET)
    public Iterable<Book> getAuthor(){
        return this.l.getAllBook();
    }

}