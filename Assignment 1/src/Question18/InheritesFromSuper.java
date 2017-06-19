package Question18;

public class InheritesFromSuper {

	public static void main(String[] args) {

		Child a = new Child();
		String str = "hey";
		
		
		if (a.upperCase(str) ) System.out.println("true");
		
		System.out.println(a.toUpper(str) );		
		
		
	}

	public static class Child extends Parent {

		Child(){;}
		public boolean upperCase(String str) {

			for (int x = 0; x < str.length(); x++)
				if (str.charAt(x) >= 'A' && str.charAt(x) <= 'Z')
					return true;

			return false;

		}
		
		
		public String toUpper(String str){
			
			String uppercase = str.toUpperCase();
			
			return uppercase;
			
			
		}

		public void outputString(String str){
			
			int sum=0; 
			
				sum=Integer.parseInt(str);
				
			
			
		
			System.out.println(sum+10);
			
		}
		

	}

	public static abstract class Parent {

		Parent(){;}
		
		public abstract boolean upperCase(String str);

		public abstract String toUpper(String str);

		public abstract void outputString(String str);

	}

}
