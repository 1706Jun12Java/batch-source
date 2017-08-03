package com.bt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
public class IndexController {
    @RequestMapping(value="*", method= RequestMethod.GET)
    public String test(){
        return "static/index.html";
    }
}
