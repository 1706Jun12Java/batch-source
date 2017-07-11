package com.revature.reminder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class fileIO {

	@SuppressWarnings("unchecked")
	public static List<reminderItem> readFile() {
		List<reminderItem> reminders = new ArrayList<reminderItem>();
		try {
			FileInputStream fis = new FileInputStream("reminderList.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			reminders  = (List<reminderItem>) ois.readObject();
			ois.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return reminders; 

	}
	
	public static void writeFile(List<reminderItem> item) {
		List<reminderItem> reminders = null;
		try {
			FileOutputStream fos = new FileOutputStream("reminderList.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(reminders);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
}
