package com.revature.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BearWithAutomagic extends Bear {

	@Autowired //@Inject is pretty much synonymous 
	private Cave cave;

	@Override
	public void methodInBear() {
		System.out.println("method in "+this.getClass().getSimpleName()); //we could generalize further
		System.out.println(this.toString());
		System.out.println("cave: " + cave.getName());
		System.out.println(cave.toString());
	}
	
	public void defaultDestroy(){
		System.out.println("default destroy from bearWithAutomagic");
	}
	
	public void defaultInit(){
		System.out.println("default init from bearWithAutomagic");
	}
	

}
