package MISC;

public class PsuedoPair {

	public PsuedoPair(String first, String second) {
		super();
		this.first = first;
		this.second = second;
	}

	public PsuedoPair() {
	}

	private String first;
	private String second;

	@Override
	public String toString() {
		return "PsuedoPair [first=" + first + ", second=" + second + "]";
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

}
