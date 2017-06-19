package Question3;



public class ReverseWithoutTemp {
	
	public static String Reverse(String a, int num1, int num2 )
	{
		String str = new String(); 
		
		for(int x=0;x<a.length(); x++)
		str+=a.charAt(a.length()-x-1);
			
			System.out.println(str);
		return str;
		
	}
	
	public static void main(String[] args) {

		String a = "Hello"; 
		
		Reverse(a, 0, a.length()-1 );
		
		
		
		
		
		
	}
	
	
	

}
