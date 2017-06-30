package com.revature.leibniz.bank.dao;

import java.util.List;

import com.revature.leibniz.bank.domain.Person;
/**
 * 
 * @author Leibniz Berihuete
 * Person Dao
 */
public interface PersonDao {
	public List<Person> getPersons();
	public Person getPersonByID(int id);
	public int createPerson(Person person);
}
