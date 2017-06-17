package q13;

public class Main {
	
	public static void main(String[] args){
		String s = "";	
		for(int i = 0 ; i < 4; i++) {
		    s = (i % 2 == 0 ? "1 " : "0 ") + s;
		    System.out.println(s); 
		}

	}
}
