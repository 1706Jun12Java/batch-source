package com.ronwu.grocery;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteList {
	
	@SuppressWarnings("unchecked")
	public static List<ShoppingItem> readList(){ 
		
		List<ShoppingItem> items = new ArrayList<ShoppingItem>();
		try {
			
			FileInputStream fis = new FileInputStream("tt.tmp");
			ObjectInputStream ois = new ObjectInputStream(fis);
			items = (List<ShoppingItem>) ois.readObject();
			ois.close();
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}
		
		return items;
	} 
	
	public static void writeList(List<ShoppingItem> items){ 
		
		try {
			
			FileOutputStream fos = new FileOutputStream("tt.tmp");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(items);
			oos.close();
			
		} catch (FileNotFoundException e) { 
			e.printStackTrace();
		} catch (IOException e) { 
			e.printStackTrace();
		} 
	}
}
