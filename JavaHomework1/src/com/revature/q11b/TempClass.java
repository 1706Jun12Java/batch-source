package com.revature.q11b;

public class TempClass {
	private float num1;
	private float num2;
	
	
	@Override
	public String toString() {
		return "TempClass [num1=" + num1 + ", num2=" + num2 + "]";
	}
	public TempClass(float num1, float num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	public TempClass() {
		super();
		// TODO Auto-generated constructor stub
	}
	public float getNum1() {
		return num1;
	}
	public void setNum1(float num1) {
		this.num1 = num1;
	}
	public float getNum2() {
		return num2;
	}
	public void setNum2(float num2) {
		this.num2 = num2;
	}
	
	
	
}
