package com.revature.hello;

//this is a POJO "plain old Java object" or "bean" 
public class Batch {
	
	private String greeting;

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((greeting == null) ? 0 : greeting.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batch other = (Batch) obj;
		if (greeting == null) {
			if (other.greeting != null)
				return false;
		} else if (!greeting.equals(other.greeting))
			return false;
		return true;
	}
	
	

}
