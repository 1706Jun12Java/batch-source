package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.beans.*;

public class Driver {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

		/*
		 * Bear bear = (BearWithSetter) ac.getBean("bearWithSetter");
		 * bear.methodInBear();
		 * 
		 * Bear bear2 = (BearWithConstructor) ac.getBean("bearWithConstructor");
		 * bear2.methodInBear();
		 * 
		 * //This bear will be a distinct object from bear2, but have the same
		 * cave object //as both other bears (SCOPES!!!) Bear bear3 =
		 * (BearWithConstructor) ac.getBean("bearWithConstructor");
		 * bear3.methodInBear();
		 * 
		 * Bear bear4 = (BearWithAutoByType) ac.getBean("bearWithAutoByType");
		 * bear4.methodInBear();
		 */
		Bear bear5 = (BearWithAutoByName) ac.getBean("bearWithAutoByName");
		bear5.methodInBear();

		Bear bear6 = (BearWithAutomagic) ac.getBean("bearWithAutomagic");
		bear6.methodInBear();
		 

		((AbstractApplicationContext) ac).close();
		
		System.out.println(bear5);
		System.out.println(bear6);

	}

}
