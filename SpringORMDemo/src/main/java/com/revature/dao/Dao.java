package com.revature.dao;

import java.util.List;

import com.revature.beans.Cave;

public interface Dao {
	
	public List<Cave> getCaves();
	public void makeCave(Cave cave);

}
