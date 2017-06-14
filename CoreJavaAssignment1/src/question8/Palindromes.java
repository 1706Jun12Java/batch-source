package question8;

import java.util.ArrayList;

public class Palindromes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al =new ArrayList<String>();
		ArrayList<String> al2 =new ArrayList<String>();
		al.add("karan");
		al.add("madam");
		al.add("tom");
		al.add("civic");
		al.add("radar");
		al.add("jimmy");
		al.add("kayak");
		al.add("john");
		al.add("refer");
		al.add("billy");
		al.add("did");
		System.out.println("List one");
        for (int i=0; i<al.size(); i++)
            System.out.println(al.get(i));
        
        for(String a : al){
        	StringBuffer reverse = new StringBuffer(a);
        	reverse = reverse.reverse();
        	String temp = reverse.toString();
        	if (a.equalsIgnoreCase(temp)){
        		al2.add(a);
        	}
        }
        System.out.println("\nList two");
        for (int i=0; i<al2.size(); i++)
            System.out.println(al2.get(i));
	}

}
