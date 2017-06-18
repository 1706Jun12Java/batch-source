package com.homework1.q11b;
import com.homework1.q11a.*;

public class Main {
	public static void main(String[] args){
		FloatClass f = new FloatClass(3, 5);
		System.out.println(f.num1);
		System.out.println(f.num2);
		f.num1 = 0;
		f.num2 = 10;
		System.out.println(f.num1);
		System.out.println(f.num2);
	}
}
