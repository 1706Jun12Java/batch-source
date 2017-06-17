package com.revature.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

import com.revature.comparisons.Movie;

public class ReflectionExample {

	public static void main(String[] args) {
		
		try {
			Class clazz = Class.forName("com.revature.comparisons.Movie");
			System.out.println(clazz.getName());
			
			//print fields
			Field[] fields  = clazz.getDeclaredFields();
			for (Field field : fields) {
				System.out.println(field.getName());
			}
			
			Movie m = (Movie) clazz.newInstance();
			System.out.println(m);
			
			Field year = clazz.getDeclaredField("year");
			year.setAccessible(true);
			year.set(m,-10000);
			
			System.out.println(m);
			
			Class clazz2 = Class.forName("java.lang.Math");
			System.out.println(clazz2.getName());
			Method[] methods = clazz2.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method.toString());
			}
			Field[] mathFields = clazz2.getDeclaredFields();
			for (Field field : mathFields) {
				System.out.println(field.getName());
			}
			
		/*	Constructor[] construct  = clazz2.getConstructors();
			for (Constructor c : construct){
				System.out.println(c.toString());
			}
			Math math = (Math) clazz2.newInstance();
			Field pi = clazz2.getDeclaredField("PI");
			pi.setAccessible(true);
			pi.set(, value);*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
