package com.revature.reminder;

import java.io.Serializable;

public class reminderItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8818177892005646116L;
	public reminderItem(String reminder, String date) {
		super();
		this.reminder = reminder;
		this.date = date;
	}
	public reminderItem() {
	}
	
	public String reminder; 
	public String date; 

}
