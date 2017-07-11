package com.ronwu.grocery;

import java.io.Serializable;

public class ShoppingItem implements Serializable {
	 
	private static final long serialVersionUID = -1148170989669991965L;
	
	public ShoppingItem(String item, String amount) {
		super();
		this.item = item;
		this.amount = amount;
	}
	
	public String item;
	public String amount;
}
