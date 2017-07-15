package com.revature.leibniz.ers.util;

public class Debug {
	public static void printMessage(Class classObject, String title, String message) {
		String className =classObject.getSimpleName();
		String dash = "---------";
		int total = className.length() + title.length() + message.length();
		
		for(int i = 0; i < total; i++){
			dash+="-";
		}
		
		//System.out.println(dash);
		System.out.println("[CLASS] " + className + ", [METHOD] " + title + ": [MESSAGE] " + message);
		//System.out.println(dash +"\n\n");
	}
}
