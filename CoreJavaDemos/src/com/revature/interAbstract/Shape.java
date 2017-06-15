package com.revature.interAbstract;

public abstract class Shape implements Calculable{
	
	public Shape(String name) {
		super();
		this.name = name;
		this.getMessage();
	}

	public Shape() {
		// TODO Auto-generated constructor stub
	}

	public String name;
	
	public void getMetaMessage(){
		this.getMessage();
	}
	
	public abstract void getMessage();
}
