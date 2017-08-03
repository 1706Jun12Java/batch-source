package com.revature.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@RequestMapping(value="/",method=RequestMethod.GET)
	public String index(){
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping(value="/host",method=RequestMethod.GET)
	public String printHost() throws UnknownHostException {
		String hostIP = InetAddress.getLocalHost().getHostAddress();
		return "Hello "+hostIP+"!";
	}
	
}
