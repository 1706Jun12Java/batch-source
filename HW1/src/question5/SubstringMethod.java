package question5;

public class SubstringMethod {
	
		public static String subString(String str, int idx){
			String temp = "";
			for(int i = 0;i < idx; i++){
				temp += str.charAt(i);
			}
			return temp;
		}
		public static void main(String[] args) {
			
	
			String random = "Hello String";
			int endIndex = 3;
			System.out.println("The substring of your word is: " + subString(random,endIndex));
			//sc.close();
		}
	}


