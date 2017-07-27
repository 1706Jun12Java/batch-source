package com.revature.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.Cave;
import com.revature.dao.Dao;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		Dao dao = (Dao) ac.getBean("myDao");
		
		List<Cave> caves = dao.getCaves();
		System.out.println(caves);
		
		//Cave c = new Cave("AWESOMECAVE3",15); //IF WE REGISTERED CAVES, WE'D GET THIS FROM APP CONTEXT
		//dao.makeCave(c);
		
		((AbstractApplicationContext)ac).close();

	}

}
