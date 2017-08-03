package com.revature.Controllers;

import com.revature.Beans.Author;
import com.revature.Beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.revature.services.LibraryService;

import java.util.ArrayList;

@RestController
public class BookController {
    private LibraryService libService;

    @Autowired
    public BookController(LibraryService batService){
        this.libService = batService;
    }

    @RequestMapping(value="/all",method= RequestMethod.GET)
    public Iterable<Book> getAllBats(){
        return this.libService.getAllBooks();
    }

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public Book getBookById(@PathVariable("id") int id){
        return this.libService.getBook(id);
    }

    @RequestMapping(value="/", method = RequestMethod.GET)
    public void createBook(){
        Author a = new Author(null,"Bob","bob");
        libService.createAuthor(a);
        ArrayList<Author> meep = new ArrayList<Author>();
        meep.add(a);
        libService.createBook(new Book("Meep",1994,meep));
    }
}
