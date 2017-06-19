package Package;

import java.util.*;

public class Gene {

	static private boolean checkBank(String str, ArrayList<String> arr) {
		for (String s : arr) {
			if (str.equals(s))
				return true;
		}
		return false;
	}

	static private String replaceAtIndex(String start, String end, int index) {
		String tmp = "";
		for (int i = 0; i < start.length(); i++) {
			if (i != index) {
				tmp += start.charAt(i);
			} else {
				tmp += end.charAt(i);
			}
		}
		return tmp;
	}

	static public int checkMutations(String start, String end, ArrayList<String> bank) {
		int mutations = 0;

		if (start.equals(end))
			return mutations;
		if (!checkBank(end, bank))
			return -1;

		for (int index = 0; index < start.length(); index++) {
			if (start.charAt(index) != end.charAt(index)) {
				String tmp = start;
				start = replaceAtIndex(start, end, index);
				if (checkBank(start, bank)) {
					return checkMutations(start,end,bank) + 1;
				} else {
					start = tmp;
				}
			}
		}
		return -1;
	}
}
