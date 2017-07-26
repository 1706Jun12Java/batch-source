package com.revature.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.service.BearService;
import com.revature.service.TigerService;

public class WalkInTheWoods {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		TigerService ts = (TigerService) context.getBean("tigerService");
		
		ts.wakeUpAnimal();
		
		ts.animalChasesYou();
		
		ts.animalCatchesYou();
		
		BearService bs = (BearService) context.getBean("bearService");
		
		bs.bearHibernates();
		
		bs.wakeUpAnimal();
		
		bs.animalChasesYou();
		
		bs.animalCatchesYou();

	}

}
