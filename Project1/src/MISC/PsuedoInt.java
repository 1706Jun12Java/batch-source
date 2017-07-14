package MISC;

public class PsuedoInt {

	public PsuedoInt(int value) {
		super();
		this.value = value;
	}

	private int value;

	public PsuedoInt() {
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "PsuedoInt [value=" + value + "]";
	}

}
