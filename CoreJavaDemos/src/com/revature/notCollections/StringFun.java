package com.revature.notCollections;

import java.util.Arrays;

public class StringFun {

	public static void main(String[] args) {
		
		char[] helloArray = {'h','e','l','l','o'};
		String helloString = new String(helloArray);
		System.out.println(helloString);
		
		String str = "hello";
		String str2 = str;
		System.out.println(str.equals(str2));
		System.out.println(str==str2);
		str2 = "hi";
		System.out.println(str.equals(str2));
		System.out.println(str==str2);
		str2 = new String("hello");
		System.out.println(str.equals(str2));
		System.out.println(str==str2);
		
		//String API 
		
		//indexOf
		String str3 = "The quick brown fox jumps over the lazy dog";
		System.out.println(str3.indexOf('k'));
		System.out.println(str3.indexOf("fox"));
		
		//isEmpty
		System.out.println(str3.isEmpty());
		
		//format
		String str4 = "hello";
		str4 = String.format("%s world", str4);
		System.out.println(str4);
		
		//toUppercase
		System.out.println(str4.toUpperCase());
		
		//split
		String str5 = "cat-dog-fish";
		String[] animal = str5.split("-");
		System.out.println(Arrays.toString(animal));
		
		//contains
		System.out.println(str5.contains("cat"));
		
		//concat
		System.out.println(str3.concat(" fox"));
		System.out.println(str3);
		
		//substring
		System.out.println(str5.substring(4, 7));
		
		//trim
		System.out.println("           hi".trim());
		
		//getChars
		char[] getC = new char[5];
		str4.getChars(3, 5, getC, 0);
		System.out.println(Arrays.toString(getC));
		
		//toLowercase
		System.out.println(str3.toLowerCase());
		
		//compareTo
		System.out.println("hello".compareTo("hi"));
		
		//StringBuilder reverse
		StringBuilder sb = new StringBuilder("doom");
		sb.reverse();
		System.out.println(sb);
		
		//StringBuffer reverse
		StringBuffer sb2 = new StringBuffer("doom");
		sb2.reverse();
		System.out.println(sb2);
		
				
	}

}
