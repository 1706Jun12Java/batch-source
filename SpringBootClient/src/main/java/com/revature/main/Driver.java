package com.revature.main;

import java.io.PrintWriter;
import java.util.List;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.revature.exception.LibraryFullException;
import com.revature.model.Book;
import com.revature.service.Library;

public class Driver {

	public static void main(String[] args) {
		
		//there are better ways to set this up! Think Spring and DI! 
		String serviceUrl = "http://localhost:8083/book/all";
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(Library.class);
		factory.setAddress(serviceUrl);
		
		//set up interceptors for soap messages
		LoggingInInterceptor inInterceptor = new LoggingInInterceptor();
		LoggingOutInterceptor outInterceptor = new LoggingOutInterceptor();
		factory.getInInterceptors().add(inInterceptor);
		factory.getOutInterceptors().add(outInterceptor);
		inInterceptor.setPrintWriter(new PrintWriter(System.out));
		outInterceptor.setPrintWriter(new PrintWriter(System.out));
		
		//consume LibraryService
		
		Library library = (Library) factory.create();
		List<Book> bookList = library.getAllBooks();
		for (Book b : bookList){
			System.out.println(b);
		}
		
	}

}
