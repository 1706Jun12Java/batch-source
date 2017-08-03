package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import com.revature.client.BatClient;
import com.revature.domain.BatType;

public class Driver {

	
	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("rootBeans.xml");
		BatClient bc = ac.getBean("batClient",BatClient.class);
		
		//System.out.println(bc.getBatTypes());
		
		BatType bt = new BatType("megaMEGAMEGABATbat");
		System.out.println(bc.saveBatType(bt));
		
		//System.out.println(bc.getBatTypes());

	}

}
