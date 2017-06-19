package question8;
import java.util.ArrayList;

public class Question8 {

	public static void main(String[] args) {

		// An array list with with words;
		ArrayList<String> words = new ArrayList<String>();
		words.add("karan");
		words.add("madam");
		words.add("tom");
		words.add("civic");
		words.add("radar");
		words.add("jimmy");
		words.add("kayak");
		words.add("john");
		words.add("refer");
		words.add("billy");
		words.add("did");

		ArrayList<String> palindrome = new ArrayList<String>();
		//System.out.println(words.size());
		// int index = words.size()-1;
		//System.out.println(words.get(index));
		
		for(int i=0; i< words.size(); i++){
			StringBuffer sb = new StringBuffer(words.get(i));
			sb.reverse();
			
			if(words.get(i).equals(sb.toString()))
			{
				String  temp = sb.toString();
				palindrome.add(temp);
				System.out.println(words.get(i)+" is Palindrome");
				}
		//	else
			//	System.out.println(words.get(i)+ "is not Palindrome");
			
		}
		System.out.println("Here is palindrome in the pervious list." + palindrome);
		
	}

}
