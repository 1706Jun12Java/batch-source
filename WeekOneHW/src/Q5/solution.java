package Q5;

public class solution {
	
//	Write a substring method that accepts a string str and an integer idx and returns the
//	substring contained between 0 and idx-1 inclusive.
	
	public static void main(String[] args) {
		
		 String str = "I Love Catpuccino";
		
		 System.out.println( str);
		 System.out.println( substring(str, 10) );
	}

	public static String substring(String s, int idx){
		if (idx > s.length()){
			return s;
		}
		
		StringBuilder Str = new StringBuilder();
		
		for (int i = 0; i<idx; i++){
			Str.append(s.charAt(i));
		}
		return Str.toString();
		
	}
}
