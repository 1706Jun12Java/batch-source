package mutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MinMutation {
	
	public static final String GENESTRING = "ACGT";

	public static int mutation(String start, String end) {

		if (start == null || end == null || start.length() != 8 || end.length() != 8)
			return -1;

		if (start.equals(end))
			return 0;


		ArrayList<String> list = new ArrayList<String>();

		String temp = start;
		int len = 0;

		for (int i = 0; i < start.length(); i++) {

			if (start.charAt(i) != end.charAt(i)){
				temp = temp.substring(0, i) + end.charAt(i) + temp.substring(i + 1);
				len++;
				list.add(temp);
			}
		}

		System.out.println("Start: " + start);
		System.out.println("End: " + end);
		System.out.println("bank: " + list.toString());
		
		return len;
	}
}
