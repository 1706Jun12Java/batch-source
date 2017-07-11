package com.revature.main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class SomeData {
	
	private static HttpURLConnection urlcon;
	private static ObjectOutputStream output;
	
	public static void main(String[] args){
		HashMap<String, String> hashmap = new HashMap<>();
		hashmap.put("Will", "Smith");
		hashmap.put("Robin", "Parker");
		URL url;
	
		try{
			url = new URL("http://localhost:8080/ajaxwork");
			urlcon = (HttpURLConnection) url.openConnection();
			
			urlcon.setDoOutput(true);
			urlcon.setDoInput(true);
			output = new ObjectOutputStream(urlcon.getOutputStream());
			output.writeObject(hashmap);
			output.close();
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
