package com.revature.springbootdemo.controllers;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.revature.springbootdemo.beans.Author;
import com.revature.springbootdemo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by John on 8/3/2017.
 */
@RestController
public class AuthorController
{
    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService)
    {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index()
    {
        return "Hello World";
    }

    @RequestMapping(value = "/author/all", method = RequestMethod.GET)
    public List<Author> getAllAuthor()
    {
        return authorService.getAllAuthors();
    }

    @RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
    public Author getAuthorbyId(@RequestParam(value = "id") int id)
    {
        return authorService.getById(id);
    }

    @RequestMapping(value = "/author", method = RequestMethod.POST, consumes = "application/json" ,produces = "application/json")
    public String saveAuthor(@RequestBody String json)
    {
        Gson gson = new Gson();
        Author author = gson.fromJson(json, Author.class);

        if (author != null)
            authorService.saveAuthor(author);

        ObjectNode nodes = new ObjectNode(JsonNodeFactory.instance);
        nodes.put("status", "it saved!");

        return nodes.toString();
    }
}
