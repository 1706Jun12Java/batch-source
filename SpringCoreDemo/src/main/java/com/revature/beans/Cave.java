package com.revature.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Cave implements InitializingBean, DisposableBean {
	
	private String name;
	
	public void setName(String name){
		this.name = name;
		System.out.println("setting name");
	}
	
	public String getName(){
		return this.name;
	}

	public Cave() {
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public void destroy(){
		System.out.println("destroy");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("after properties set");
	}
	
	public void defaultInit(){
		System.out.println("default init from cave");
	}
	
	public void defaultDestroy(){
		System.out.println("default destroy from cave");
	}

}
