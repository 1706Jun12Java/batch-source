package com.revature.Controllers;

import com.revature.Beans.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.revature.services.LibraryService;

@RestController
@RequestMapping(value="/author")
public class AuthorController {
    private LibraryService libService;
    @Autowired
    public AuthorController(LibraryService batService){
        this.libService = batService;
    }

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public Iterable<Author> getAllAuthors(){
        return this.libService.getAllAuthors();
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Author getAuthorById(@PathVariable("id") int id){
        return this.libService.getAuthor(id);
    }
}
