package com.revature.fruit;

public class Fruit implements Comparable<Fruit>, Edible{
	
	int x = 10;
	static int y = 20;
	
	public void grow(){
		System.out.println("growing fruit");
	}
	
	
	public Fruit(String color, int numSeeds, String name) {
		this();
		this.color = color;
		this.numSeeds = numSeeds;
		this.name = name;
	}
	
	public Fruit (){
		super();
	}
	
	private String color;
	private int numSeeds;
	private String name;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getNumSeeds() {
		return numSeeds;
	}
	public void setNumSeeds(int numSeeds) {
		this.numSeeds = numSeeds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Fruit [color=" + color + ", numSeeds=" + numSeeds + ", name=" + name + "]";
	}
	
	//expected behavior: 
		//if two objects are equal according to .equals(), calling 
		//hashcode() on each should return the same int value
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numSeeds;
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
		Fruit other = (Fruit) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numSeeds != other.numSeeds)
			return false;
		return true;
	}


	@Override
	public int compareTo(Fruit o) {
		return this.numSeeds - o.numSeeds;
	}

}
