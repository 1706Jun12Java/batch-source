package com.revature.collections;

import java.util.*;
import java.util.Map.*;

public class MapExamples {

	public static void main(String[] args) {
		
		Map<Integer,String> hashMap = new HashMap<>();
		hashMap.put(4, "John Smith");
		hashMap.put(5, "Johann Smith");
		hashMap.put(6, "Juan Smith");
		
		System.out.println(hashMap);
		
		hashMap.put(6, "Joan Smith"); //no duplicate keys- just changed the value for #6
		
		System.out.println(hashMap);
		
		System.out.println("hashMap size: "+hashMap.size());
		System.out.println("hashMap value for key 5: "+hashMap.get(5));
		
		
		//the EntrySet IS a Collection! 
		for(Entry<Integer,String> entry : hashMap.entrySet()){
			System.out.println(entry.getKey()+"\t"+entry.getValue());
			System.out.println(entry.toString());
			
		}
		
		

	}

}
